#!/bin/bash
echo "y/N?"
read answer
echo "answer: $answer" 
read -p 'id: ' id
read -sp 'pw: ' pw;
printf "\n\nid: $id, pw: $pw"