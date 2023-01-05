#!/bin/sh

set -e

if [ -z "$1" ]
then
  echo "\$1 (docker.mysql.app.init.d) path is NULL"
  exit 1
fi