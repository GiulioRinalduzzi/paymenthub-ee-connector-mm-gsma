# paymenthub-ee-connector-mm-gsma

A Payment Hub EE connector that talks to mobile money providers using the GSMA Mobile Money API.

[![License](https://img.shields.io/badge/License-MPL--2.0-blue.svg)](LICENSE)

## What it does

- Sends money transfers and deposits to mobile money accounts through the GSMA Mobile Money API.
- Gets an OAuth access token from the provider and reuses it until it expires.
- Looks up account details such as status, name, and balance for a given identifier.
- Checks the state of a transaction and tracks it with correlation IDs.
- Handles provider callbacks and reports the result back into the payment flow.
- Runs as Zeebe workers so the steps fit into a Camunda/Zeebe business process.

## How it fits into Payment Hub EE

Payment Hub EE runs payment flows as Zeebe (Camunda) workflows. This connector is the piece that
speaks to GSMA mobile money operators. When a workflow reaches a step that needs a mobile money
action, a Zeebe worker in this connector picks up the job, calls the operator's GSMA API through
Apache Camel routes, and returns the outcome to the workflow so it can move on.

## Tech stack

- Java 21
- Spring Boot 3.4
- Apache Camel 4 (routes and HTTP client)
- Zeebe (Camunda) job workers
- Gradle build
- Depends on `paymenthub-ee-bom` (version management) and `paymenthub-ee-core` (shared connector code)

## Branches

- `dev` is the active development branch — all PRs should target `dev`.
- `main` holds released versions.

## Contributing

See [contributing.md](contributing.md), our [Code of Conduct](CODE_OF_CONDUCT.md) and the [security policy](security.md).
