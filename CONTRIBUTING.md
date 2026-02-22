# Contributing to ReWire

Hi Team! To maintain high code quality and a smooth workflow, please follow these guidelines.

---

## Branching Strategy
- **Main Branch:** The `main` branch is protected. No one pushes directly to it.
- **Feature Branches:** All work happens on branches. 
  - Naming: `feat/feature-name` or `fix/bug-description`.
- **Syncing:** Always pull the latest `main` before starting a new branch.

## Technical Standards
- **Java Version:** JDK 11
- **Build Tool:** Maven (Ensure your `pom.xml` is never committed with local absolute paths).
- **Lombok:** Use Lombok annotations (`@Data`, `@Builder`, etc.) to reduce boilerplate.
- **Formatting:** We use "Format on Save" in VS Code via the project's `.vscode/settings.json`.

## Development Workflow
1. **Pick a Task:** Find an issue on the [Project Board](https://github.com/orgs/Axono-ReWire/projects/1)).
2. **Create Branch:** `git checkout -b feat/your-task-name`.
3. **Write Code:** - Ensure you follow the Checkstyle rules (no yellow squiggles in VS Code).
   - Write JUnit tests for any new logic.
4. **Local Verification:** Run `mvn clean test` to ensure everything passes locally.
5. **Sync Before PR:** Make sure to merge the main branch into your branch before submitting a PR to avoid conflicts.
6. **Push & PR:** Push your branch and open a Pull Request using the provided template.

## How to Submit a Pull Request (PR)
1. **Open GitHub:** Open our Repository.
2. **Compare & Pull Request:** 
3. **Title & Description:** 
4. **Assignee & Reviewers:** Assign the PR to yourself
5. **Submit:** Click **Create Pull Request**.

## Testing Requirements
- Every new feature must include a corresponding JUnit test class in `src/test/java`.
- Work with Jenitha to make your tests.

## The Merge Process
1. Once a PR is opened, **GitHub Actions** will automatically check your code style and run tests.
2. If the build fails (Red X), you must fix the code before it will be reviewed.
3. **Wait for Approval**: DO NOT Merge your own Pull Request.
4. Nifemi will review the code, leave comments, and perform the final **Squash and Merge**.

## Communication
- Use **GitHub Issues** for technical discussions. Make sure to mention in the discord whenever you open an issue.
- Use the `fix: ` and `feat: ` prefixes in your commit messages.