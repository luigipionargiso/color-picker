# Development Plan

> How we work (from `CLAUDE.md`): every step is defined and agreed before anyone acts; the developer does many steps personally; Claude writes boilerplate and infrastructure and guides the rest. Last updated: 2026-11-17.

## Phases

| # | Phase | Status |
|---|---|---|
| 0 | Environment setup (Android Studio, SDK, Git, `gh`, phone debugging) | ✅ Done (2026-11-10) |
| 1 | Product & design (scope, screens, low-fi wireframes, visual direction, [spec](PRODUCT_SPEC.md)) | ✅ Done (2026-11-14) |
| 2 | Project skeleton (repo, Android project, quality tools, CI, `:core:color`, architecture, theme) | ▶️ In progress |
| 3 | Color engine (`:core:color`): conversions, distances, names, harmonies, dominant colors, tests | ⏳ |
| 4 | Features: camera, picker, color values, name & similar, palettes, history, settings | ⏳ |
| 5 | Polish: animations, accessibility, adaptive layouts, screenshot tests, Baseline Profile | ⏳ |
| 6 | Release prep: name & icon, signing, R8, privacy policy, store listing, closed test (12 testers × 14 days), production | ⏳ |
| 7 | Post-launch: vitals, updates, 1.1 (comparison + grey-card calibration) | ⏳ |

## Phase 2 — Project skeleton

**Done when**: the app opens on the phone and navigates between placeholder screens, `./gradlew check` passes locally, all 4 pull requests are merged with green CI.

| # | Step | Who | PR | Status |
|---|---|---|---|---|
| 0 | **Rename the project folder** to `C:\dev\color-picker-app` (spaces in paths break some Android/Gradle tools on Windows), then open a new Claude session there | Developer | — | ✅ |
| 1 | **Git + GitHub**: `git init`, `.gitignore`, `LICENSE` (MPL-2.0), first `README.md`, first commit of the docs, create the **public** repo with `gh repo create`, push | Developer runs the commands, Claude prepares the files | — (direct to `main`) | ✅ 2026-11-15 |
| 2 | **Create the Android project** with Android Studio's *Empty Activity* template: working name "Color Picker", package `io.github.luigipionargiso.colorpicker`, minSdk 26, Kotlin DSL. Run it on the phone | Developer | 1 | ✅ 2026-11-15 |
| 3 | **Guided tour** of the generated files: Gradle files, version catalog, manifest, `MainActivity`, theme. Gradle part recorded in [BUILD.md](BUILD.md) | Claude explains | 1 | ✅ 2026-11-17 |
| 4 | **Build setup cleanup**: latest stable versions (Kotlin 2.4.21, Compose BOM 2026.09.00, Gradle 9.9.1), SDK 37, Java 17 toolchain, R8 on the whole app, parallel builds + build cache, remove template leftovers | Claude | 1 | ✅ 2026-11-17 |
| 5 | **Code quality tools**: Spotless + ktlint, detekt + Compose rules, Android Lint, `.editorconfig`. Recorded in [BUILD.md](BUILD.md#code-quality) | Claude | 2 | ✅ 2026-11-24 |
| 6 | **CI**: GitHub Actions on every PR and push to `main` (formatting, detekt, lint, unit tests, debug build); protect `main` (PR + green CI required) | Claude writes the workflow; developer sets branch protection | 2 | |
| 7 | **`:core:color` module** (pure Kotlin): first function (HEX parsing) and first unit test | Developer, guided | 3 | |
| 8 | **Architecture skeleton**: Hilt, package structure, Navigation 3 with a placeholder for every screen | Claude boilerplate; developer writes one placeholder screen | 4 | |
| 9 | **Theme foundation**: bundled Inter, neutral light/dark color schemes with ink accent, typography with tabular figures, shapes; dynamic color off; XML launch theme follows dark mode | Claude; developer reviews in previews | 4 | |
| 10 | **Docs**: README, decision log entries in the spec, this plan's status | Claude | each PR | |

Notes carried forward:
- **Phase 4**: decide the backup rules (`allowBackup` is on with empty rules: palettes probably yes, photo copies no).

Each step gets a short, detailed plan (exact commands/files) agreed right before it is executed.
