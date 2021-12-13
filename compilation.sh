#!/bin/sh
find -name "*.java" > sources.txt
javac -d build -cp :* @sources.txt
java -cp build main.Main