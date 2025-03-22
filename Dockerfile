FROM ubuntu:latest
LABEL authors="fernandoareias"

ENTRYPOINT ["top", "-b"]