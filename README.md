# Color Picker (working title)

[![CI](https://github.com/luigipionargiso/color-picker/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/luigipionargiso/color-picker/actions/workflows/ci.yml)

An Android color picker for artists and designers. Point the camera at anything (or open a photo), pick a color with pixel precision, learn its name, explore related colors, and collect palettes.

> **Status:** in development. The project skeleton is being set up (Phase 2 of the [development plan](docs/DEVELOPMENT_PLAN.md)); there is no installable build yet.

## Planned features (1.0)

- **Pixel-precise picking**: a fixed crosshair with the photo moving underneath, a magnifier, and 1px / 3×3 / 5×5 sampling.
- **Evocative color names**: the nearest of ~32,000 named colors, with a one-line description.
- **Color values**: HEX, RGB, HSL, HSV, CMYK, CIELAB, OKLCH, plus WCAG contrast checks.
- **Explore**: similar named colors, tints, shades, tones, and harmonies.
- **Palettes**: create, reorder, and export as text, image, JSON, or CSS variables.
- **History** of every pick, with the source photo.
- **Offline and private**: everything runs on the device, no accounts, no internet permission.

## Tech stack

Kotlin, Jetpack Compose with Material 3, MVVM with unidirectional data flow, Hilt, Room, DataStore, CameraX, and a pure-Kotlin color science module. Details in [docs/TECH_STACK.md](docs/TECH_STACK.md).

## Documentation

| Document | Contents |
|---|---|
| [Product spec](docs/PRODUCT_SPEC.md) | Scope, screens, navigation, color data, roadmap, decision log |
| [Development plan](docs/DEVELOPMENT_PLAN.md) | Phases and current progress |
| [Tech stack](docs/TECH_STACK.md) | Libraries, tooling, engineering practices |
| [Build setup](docs/BUILD.md) | Gradle files, code quality tools, useful commands |
| [CI](docs/CI.md) | GitHub Actions workflow and the rules on `main` |
| [Naming](docs/NAMING.md) | App name candidates |

## License

[Mozilla Public License 2.0](LICENSE).
