FROM mongo:5

ARG MONGO_USERNAME
ARG MONGO_PASSWORD
ARG MONGO_DATABASE

ENV MONGO_INITDB_ROOT_USERNAME=$MONGO_MONGO_USERNAME
ENV MONGO_INITDB_ROOT_PASSWORD=$MONGO_PASSWORD
ENV MONGO_INITDB_DATABASE=$MONGO_DATABASE

COPY ./init-mongo-db-with-collections.js /docker-entrypoint-initdb.d/

VOLUME ./init-mongo-db-with-collections.js:/docker-entrypoint-initdb.d/init-mongo-db-with-collections.js:ro


# CMD ["mongod", "--config", "/etc/mongod.conf.orig"]

