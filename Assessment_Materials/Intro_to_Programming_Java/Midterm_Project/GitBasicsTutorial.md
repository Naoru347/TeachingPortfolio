# Git Basics Tutorial: Version Control for Group Projects (Java Edition)

Git is an essential tool for managing code in collaborative Java projects. This tutorial will help you understand how to use Git for your midterm project, focusing on team workflows and good version control practices.

---

## Why Use Git?

- **Version Control:** Tracks changes to your Java files over time and allows for recovery from mistakes.
- **Collaboration:** Multiple developers can work on the same project without conflicts.
- **Organization:** Keeps your project directory organized and maintains a complete change history.

---

## Key Git Concepts

1. **Repository (Repo):** A project folder tracked by Git. In your case, this contains all `.java` files and documentation.
2. **Commit:** A snapshot of your project at a point in time.
3. **Branch:** A separate track of development used to try features without affecting the main project.
4. **Merge:** Combines different branches into one shared history.
5. **Remote Repository:** An online repo (e.g., GitHub) for syncing your code across teammates.

---

## Getting Started

### Step 1: Set Up Git

1. Download Git from [git-scm.com](https://git-scm.com/).
2. Configure Git:
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

---

### Step 2: Clone the Repository

Each team member clones the GitHub repo:
```bash
git clone <repository-url>
cd <repository-folder>
```

---

## Core Git Commands

### 1. Check Status
```bash
git status
```

### 2. Stage and Commit Changes
```bash
git add Main.java
git commit -m "Add main menu navigation"
```

To stage everything:
```bash
git add .
```

### 3. Push Changes to GitHub
```bash
git push
```

### 4. Pull Changes from GitHub
```bash
git pull
```

### 5. Resolve Merge Conflicts
Git will mark conflict zones like this:
```
<<<<<<< HEAD
Your changes
=======
Their changes
>>>>>>> branch
```
Edit, fix, and then:
```bash
git add .
git commit -m "Resolved merge conflict in Main.java"
```

---

## Best Practices for Java Group Work

- **Communicate:** Use Slack, Discord, or GitHub Issues.
- **Commit Often:** Small commits are easier to debug and merge.
- **Pull Before Push:** Prevents most conflicts.
- **Use Branches:** Try new features without breaking the main build:
```bash
git checkout -b add-customer-feature
```
- **Clean Repos:** Use `.gitignore` to skip files like `.class`, `.DS_Store`, and IDE configs.

---

## Sample Team Workflow

1. **Team Lead:**
   - Creates GitHub repo, adds collaborators.

2. **Members:**
   - Clone, work locally, commit, and push changes.
   - Coordinate via branches or assigned tasks.

3. **Before Submission:**
   - Merge all tested code into `main`.
   - Final check of all class files and `README.md`.

---

## Git Command Reference

| Command                    | Description                               |
|----------------------------|-------------------------------------------|
| `git clone <url>`          | Clone remote repository locally           |
| `git status`               | View modified files and branch status     |
| `git add <file>`           | Stage file changes                        |
| `git commit -m "<msg>"`    | Commit staged changes with a message      |
| `git push`                 | Upload commits to GitHub                  |
| `git pull`                 | Fetch latest changes from GitHub          |
| `git branch <name>`        | Create a new branch                       |
| `git checkout <name>`      | Switch to a branch                        |
| `git merge <name>`         | Merge another branch into your current one|

---

## Final Tips

- Always write meaningful commit messages.
- Delete unused branches after merging.
- Ask for help early if stuck on Git.

Git is an essential tool in every programmer’s toolkit—learning it now will benefit you in every future group project, internship, or job.