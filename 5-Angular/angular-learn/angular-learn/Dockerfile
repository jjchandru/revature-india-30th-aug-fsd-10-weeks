FROM node:latest as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app
RUN npm install
RUN npm run build -- --base-href='/angular-learn/'

FROM nginx:latest
COPY dist/angular-learn /usr/share/nginx/html
EXPOSE 5000
