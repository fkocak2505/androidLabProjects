#!/bin/bash
echo "Github Push Starting.."

git add *
git commit -m "updated"
git push origin master

echo "Pushing done.. "
read