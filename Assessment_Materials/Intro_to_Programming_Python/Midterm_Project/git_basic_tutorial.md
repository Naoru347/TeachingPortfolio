# **Git Basics Tutorial: Version Control for Group Projects**

Git is an essential tool for managing code in collaborative projects. This tutorial will help you understand how to use Git for your midterm project, focusing on group workflows.

---

## **Why Use Git?**

- **Version Control:** Tracks changes to your code over time, allowing you to revert to previous versions if needed.
- **Collaboration:** Enables multiple people to work on the same project simultaneously without overwriting each other’s changes.
- **Organization:** Keeps your project files and history organized in a central repository.

---

## **Key Git Concepts**

1. **Repository (Repo):** A project folder tracked by Git. It stores your code and its version history.
2. **Commit:** A snapshot of your code at a specific point in time.
3. **Branch:** A separate line of development, useful for adding new features without affecting the main codebase.
4. **Merge:** Combines changes from one branch into another.
5. **Remote Repository:** A repository hosted online (e.g., GitHub) for team collaboration.

---

## **Getting Started**

### **Step 1: Set Up Git**

1. **Install Git:**
   - Download and install Git from [git-scm.com](https://git-scm.com/).
   - Verify the installation by running:
     ```bash
     git --version
     ```

2. **Set Your Identity:**
   Configure your Git username and email (this will appear in the commit history):
   ```bash
   git config --global user.name "Your Name"
   git config --global user.email "your.email@example.com"
   ```

---

### **Step 2: Clone the Repository**

To work on your group project, each team member needs to clone the repository to their local machine:

1. Go to your project’s GitHub repository.
2. Copy the repository URL.
3. Run the following command in your terminal:
   ```bash
   git clone <repository-url>
   ```
4. Navigate into the cloned repository folder:
   ```bash
   cd <repository-folder-name>
   ```

---

## **Basic Commands for Group Collaboration**

### **1. Checking the Current Status**
Before making any changes, check the status of your repository:
```bash
git status
```

This shows:
- Which files have been modified.
- Which files are staged for commit.

---

### **2. Adding and Committing Changes**

After making changes to your files:
1. **Stage Your Changes:**
   Add the files you want to commit:
   ```bash
   git add <file-name>
   ```
   Or add all modified files:
   ```bash
   git add .
   ```

2. **Commit Your Changes:**
   Save your changes with a meaningful message:
   ```bash
   git commit -m "Describe what you changed"
   ```

---

### **3. Pushing Changes to the Remote Repository**

Once you’ve committed your changes locally, push them to the shared repository:
```bash
git push
```

---

### **4. Pulling Changes from the Remote Repository**

Before starting new work, pull the latest changes from the repository to ensure your local copy is up to date:
```bash
git pull
```

---

### **5. Resolving Merge Conflicts**

When multiple team members edit the same file, Git may encounter conflicts. Here’s how to resolve them:

1. Git will notify you of the conflict during a `git pull` or `git merge`.
2. Open the conflicting file. Look for sections marked like this:
   ```plaintext
   <<<<<<< HEAD
   Your changes
   =======
   Changes from the repository
   >>>>>>> branch-name
   ```
3. Edit the file to keep the correct changes.
4. Stage and commit the resolved file:
   ```bash
   git add <file-name>
   git commit -m "Resolved merge conflict in <file-name>"
   ```

---

## **Best Practices for Group Work**

### **1. Communicate with Your Team**
- Discuss who is working on which part of the project.
- Use GitHub Issues or a shared document to track tasks.

### **2. Commit Frequently**
- Commit your work in small, logical steps.
- Include meaningful commit messages to document your progress.

### **3. Pull Before You Push**
- Always pull the latest changes before making new commits.
- This minimizes the risk of conflicts.

### **4. Use Branches for New Features**
- Create a new branch for experimental features or enhancements:
  ```bash
  git branch feature-name
  git checkout feature-name
  ```
- Merge the branch into the main branch after testing:
  ```bash
  git checkout main
  git merge feature-name
  ```

### **5. Keep the Repository Clean**
- Avoid committing unnecessary files (e.g., temporary files, IDE configurations).
- Use a `.gitignore` file to exclude irrelevant files.

---

## **Example Workflow for Your Group Project**

1. **Project Manager:**
   - Sets up the repository on GitHub.
   - Adds team members as collaborators.

2. **Team Members:**
   - Clone the repository.
   - Work on assigned tasks in separate branches or on the main branch (if tasks don’t overlap).
   - Commit changes locally and push to the remote repository.

3. **Collaboration:**
   - Communicate before pushing large changes to avoid conflicts.
   - Review each other’s commits and provide feedback.

4. **Final Steps:**
   - Merge all changes into the main branch.
   - Ensure the repository is clean and ready for submission.

---

## **Quick Reference Commands**

| **Command**                | **Description**                                                                 |
|----------------------------|---------------------------------------------------------------------------------|
| `git clone <url>`          | Clone a remote repository to your local machine.                               |
| `git status`               | Check the status of your repository (e.g., modified files).                    |
| `git add <file>`           | Stage a file for commit.                                                       |
| `git add .`                | Stage all modified files for commit.                                           |
| `git commit -m "<message>"`| Commit changes with a message describing what was done.                        |
| `git push`                 | Push your local commits to the remote repository.                              |
| `git pull`                 | Pull the latest changes from the remote repository to your local machine.      |
| `git branch <name>`        | Create a new branch.                                                           |
| `git checkout <branch>`    | Switch to a different branch.                                                  |
| `git merge <branch>`       | Merge a branch into the current branch.                                        |
