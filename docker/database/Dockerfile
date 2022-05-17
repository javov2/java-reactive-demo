FROM postgres:11-alpine
RUN mkdir "/docker-entrypoint-init.d/"
COPY initdb/CREATE_EXTENSION.sql /docker-entrypoint-initdb.d/
