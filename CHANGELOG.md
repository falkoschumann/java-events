Changelog
=========

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Changed

*   Upgrade to Java 11.
*   Upgrade to JUnit 5.
*   Change FindBugs to SpotBugs.

## [1.1.0] - 2017-08-03

### Added

*   Library is an OSGi bundle and Eclipse plug-in also.

### Added

*   The JAR is also an OSGi bundle.
*   Add `Action` for events without message data.
*   Update Copyright.

## [1.0.1] - 2016-04-24

### Fixed

*   Fix JavaDoc. The `Event` class _is_ synchronized.

## 1.0.0 - 2016-04-10

### Added

*   Add `Event&lt;T&gt;`.
*   Add `IntEvent`.
*   Add `LongEvent`.
*   Add `DoubleEvent`.


[Unreleased]: https://github.com/falkoschumann/java-events/compare/v1.1.0...HEAD
[1.1.0]: https://github.com/falkoschumann/java-events/compare/v1.0.1...v1.1.0
[1.0.1]: https://github.com/falkoschumann/java-events/compare/v1.0.0...v1.0.1
