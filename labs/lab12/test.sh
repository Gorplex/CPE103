#!/bin/sh


java TSort $1 > out.tmp

diff -wB out.tmp $2

