## enumerate SPNs with 
## this script will *query the network for the name of the Primary domain controller emulator and the domain*, *search Active Directory and filter the output to display user accounts*, and then clean up the output for readability. (PWK p626)
## Active Directory general enumeration:
## users, SPN

## Step 1:
## Build the *LDAP search string* with the domain object
$domainObj = [System.DirectoryServices.ActiveDirectory.Domain]::GetCurrentDomain()
    ## Forest : corp.com
    ## DomainControllers : {DC01.corp.com}
    ## Children : {}
    ## DomainMode : Unknown
    ## DomainModeLevel : 7
    ## Parent :
    ## PdcRoleOwner : DC01.corp.com                       <-- $PDC
    ## RidRoleOwner : DC01.corp.com
    ## InfrastructureRoleOwner : DC01.corp.com            <-- $DistinguishedName
    ## Name : corp.com

$PDC = ($domainObj.PdcRoleOwner).Name
$DistinguishedName = "DC=$($domainObj.Name.Replace('.', ',DC='))"
  ## DC=corp,DC=com

## $SearchString format: LDAP://<PdcRoleOwner>/<Name.split('.')...>
## e.g.: LDAP://DC01.corp.com/DC=corp,DC=com
$SearchString = "LDAP://"
$SearchString += $PDC + "/"
$SearchString += $DistinguishedName
Write-Output "using SearchString: $SearchString"

## Step 2:
## use System.DirectorySearcher and *LDAP filters* to find the object info in the entire AD
$Searcher = New-Object System.DirectoryServices.DirectorySearcher([ADSI]$SearchString)
$objDomain = New-Object System.DirectoryServices.DirectoryEntry
$Searcher.SearchRoot = $objDomain

## ref1: [LDAP Famous filters](http://www.ldapexplorer.com/en/manual/109050000-famous-filters.htm)
## ref2: [common SPNs](https://adsecurity.org/?page_id=183)
## find all user account(805306368) || computer/machine account: (805306369)
$Searcher.filter="samAccountType=805306368"
## find all SPNs
# $search.filter = "(servicePrincipalName=*)"
## find all Groups (nested && none nested)
# $Searcher.filter="(objectClass=Group)"
## SPN for http web services that support Kerberos authentication
# $Searcher.filter="serviceprincipalname=*http*"

$Result = $Searcher.FindAll()
## Expected $Result with filter "samAccountType=805306368":
## | Path                                            | Properties      |
## |-------------------------------------------------+-----------------|
## | LDAP://CN=Administrator,CN=Users,DC=corp,DC=com | {admincount...} |
## | LDAP://CN=Guest,CN=Users,DC=corp,DC=com         | {iscritical...} |

## clean-up and output
Foreach($obj in $Result)
{
    Foreach($prop in $obj.Properties)
    {
        $prop
    }
    Write-Host"------------------------"
}

## Expected $prop:
## givenname                     {Jeff_Admin}
## samaccountname                {jeff_admin}
## cn                            {Jeff_Admin}
## ...
## samaccounttype                {805306368}
## ...
## userprincipalname             {jeff_admin@corp.com}
## useraccountcontrol            {66048}
## admincount                    {1}
## dscorepropagationdata         {05/02/2018 19.20.52, 01/01/1601 00.00.00}
## distinguishedname             {CN=Jeff_Admin,OU=Admins,OU=CorpUsers,DC=corp,DC=com}
## objectclass                   {top, person, organizationalPerson, user}
## usncreated                    {12879}
## memberof                      {CN=Domain Admins,CN=Users,DC=corp,DC=com}
## adspath                       {LDAP://CN=Jeff_Admin,OU=Admins,OU=CorpUsers,DC=corp,DC=com}
## ...
