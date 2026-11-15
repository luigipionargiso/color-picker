# Tech Stack & Tooling

> Approved 2026-11-09, updated 2026-11-14. Exact library versions live in `gradle/libs.versions.toml` (latest stable at setup time).

## App

| Area | Choice | Why |
|---|---|---|
| Language | **Kotlin 2.x** + Coroutines/Flow | Google's official Android language; Flow drives reactive UI state |
| UI | **Jetpack Compose + Material 3** | Current standard UI toolkit |
| Navigation | **Navigation 3** | Compose-first navigation with type-safe routes |
| Architecture | **MVVM + unidirectional data flow**, layers `ui → domain → data`, repository pattern | Standard, testable, easy to explain |
| State | `ViewModel` + `StateFlow`, immutable UI state classes | Survives configuration changes; predictable |
| Dependency injection | **Hilt** | The most common choice in Android jobs |
| Local storage | **Room** (palettes, history) + **DataStore** (settings) | Official Jetpack persistence |
| Camera | **CameraX** | In-app viewfinder, capture, focus, zoom, torch |
| Photo input | **Photo Picker** (system) | No storage permission needed |
| Image loading | **Coil 3** | Kotlin/Compose-native |
| Color science | Own pure-Kotlin **`:core:color`** module: RGB/HEX/HSL/HSV/CMYK/CIELAB/OKLab/OKLCH, ΔE, nearest-name lookup, dominant colors, harmonies, contrast | Core of the app, 100% unit-testable |
| Color names | `color-name-list` + taglines from `color-name-api`, bundled | Offline; MIT, attribution required |
| Serialization | **kotlinx.serialization** | Datasets and palette export |
| Font | **Inter** (bundled, SIL Open Font License) | Visual direction; tabular figures for values |
| SDK levels | `minSdk 26`, `compileSdk`/`targetSdk` = latest (37 at setup) | ~97% of devices; Play requires a recent target |

**Modules**: `app` (organized by feature/layer packages) + pure-Kotlin `:core:color`. Further split into `:feature:*` modules later, as an explicit learning step.

## Engineering practices

- **Build**: Gradle Kotlin DSL, version catalog, **KSP** (Hilt, Room).
- **Code quality**: **Spotless + ktlint** (formatting), **detekt** + Compose rules (static analysis), Android Lint, `.editorconfig`.
- **Testing**: JUnit + Google Truth + **Turbine** (Flow), hand-written fakes over mocks; Compose UI tests; **Roborazzi** screenshot tests (Phase 5).
- **Git workflow**: public GitHub repo, protected `main`, short feature branches, pull requests, Conventional Commits.
- **CI/CD**: **GitHub Actions** — on every PR: formatting, detekt, lint, unit tests, debug build. Later: signed release AAB on tag.
- **Performance/size**: R8 shrinking, **Baseline Profiles** (Phase 5).
- **License**: MPL-2.0.

## Tools across the lifecycle

| Phase | Tools |
|---|---|
| Development | Android Studio (latest stable), Git, GitHub + `gh` CLI, physical phone (moto g54 5G) with USB debugging; optional scrcpy |
| Design | Figma (private wireframes file), Android Studio Image Asset Studio (adaptive + themed icon) |
| Release | Google Play Console ($25 one-time), Play App Signing + upload keystore (never committed, backed up), privacy policy page (e.g. GitHub Pages), closed test with ≥12 testers for 14 days (required for new personal accounts), store assets (512×512 icon, 1024×500 feature graphic, screenshots) |
| Operations | Play Console Android vitals (crash reporting beyond that: open question in the spec) |
