ARG GRAAL_VERSION=latest
FROM ghcr.io/graalvm/graalvm-ce:${GRAAL_VERSION}
WORKDIR /opt/native-image
RUN gu install native-image
ENTRYPOINT ["native-image"]