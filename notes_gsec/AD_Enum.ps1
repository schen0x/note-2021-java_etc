## Active Directory general enumeration:
## users, SPN

## build the LDAP search string with the domain object
$domainObj = [System.DirectoryServices.ActiveDirectory.Domain]::GetCurrentDomain()
$PDC = ($domainObj.PdcRoleOwner).Name
$SearchString = "LDAP://"
$SearchString += $PDC + "/"
$DistinguishedName = "DC=$($domainObj.Name.Replace('.', ',DC='))"
$SearchString += $DistinguishedName
$SearchString

## LDAP://<PdcRoleOwner>/<Name.split('.')...>
## LDAP://DC01.corp.com/DC=corp,DC=com

## instantiate Searcher, Searcher.SearchRoot set to the entire AD
$SearchString += $DistinguishedName
$Searcher = New-Object System.DirectoryServices.DirectorySearcher([ADSI]$SearchString)
$objDomain = New-Object System.DirectoryServices.DirectoryEntry
$Searcher.SearchRoot = $objDomain

## set filters, or search: *LDAP Famous filters*
## user account: 805306368, computer/machine account: 805306369
$Searcher.filter="samAccountType=805306368"
# $Searcher.filter="samAccountType=805306369"

## enum SPN, search for SPNs
## https://adsecurity.org/?page_id=183
# $Searcher.filter="serviceprincipalname=*http*"

    ## $Searcher.FindAll()

    ## | Path                                            | Properties      |
    ## |-------------------------------------------------+-----------------|
    ## | LDAP://CN=Administrator,CN=Users,DC=corp,DC=com | {admincount...} |
    ## | LDAP://CN=Guest,CN=Users,DC=corp,DC=com         | {iscritical...} |

$Result = Searcher.FindAll()

Foreach($obj in $Result)
{
    Foreach($prop in $obj.Properties)
    {
        $prop
    }
    Write-Host"------------------------"
}
