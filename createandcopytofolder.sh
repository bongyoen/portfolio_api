#!/bin/bash
[[ -d artifacts ]] && rm -r artifacts
mkdir artifacts
cp -R build/libs artifacts
