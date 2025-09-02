# Git Workflow Cheat Sheet
## CSC 220: Data Structures & Algorithms

This cheat sheet covers essential Git commands and workflows you'll use throughout the course for individual labs and team projects.

---

## Essential Git Commands

### Repository Setup
```bash
# Clone a repository (download from GitHub)
git clone <repository-url>
git clone https://github.com/username/repo-name.git

# Navigate into the repository
cd repo-name

# Check repository status
git status
```

### Daily Workflow Commands
```bash
# Check what files have changed
git status

# Add specific files to staging area
git add filename.java
git add src/main/java/MyClass.java

# Add all changed files
git add .

# Commit staged changes with a message
git commit -m "Your commit message here"

# Push changes to remote repository
git push

# Pull latest changes from remote repository
git pull
```

### Information Commands
```bash
# View commit history
git log
git log --oneline    # Condensed view

# See what changes have been made
git diff             # Changes not yet staged
git diff --staged    # Changes that are staged

# Show current branch and tracking info
git branch -v
```

---

## Course Commit Message Standards

### Format Template
```
type: Brief description (50 characters max)

Longer explanation if needed (wrap at 72 characters)
- Bullet points for multiple changes
- Reference issue numbers if applicable
```

### Commit Types
- **feat:** New feature or functionality
- **fix:** Bug fix or error correction
- **docs:** Documentation changes only
- **test:** Adding or modifying tests
- **refactor:** Code restructuring without feature changes
- **style:** Formatting changes (spacing, semicolons, etc.)
- **chore:** Maintenance tasks (build updates, dependencies)

### Examples of Good Commit Messages

**For Lab Work:**
```bash
git commit -m "feat: implement SimpleArrayList add() and get() methods

- Add() method handles dynamic resizing
- Get() method includes bounds checking
- Both methods include proper error handling"

git commit -m "test: add comprehensive unit tests for ArrayList

- Test normal operations (add, get, size)
- Test edge cases (empty list, bounds checking)
- Test dynamic resizing functionality"

git commit -m "fix: resolve IndexOutOfBoundsException in get() method

Previously threw exception for valid indices when list was empty.
Now properly checks size before array access."
```

**For Team Projects:**
```bash
git commit -m "feat: implement AVL tree rotation algorithms

- Add single left and right rotations
- Add double left-right and right-left rotations
- Include balance factor updates for all cases"

git commit -m "docs: update README with build and testing instructions

- Add compilation steps for IntelliJ and VS Code
- Include instructions for running JUnit tests
- Document project structure and file organization"
```

### Examples of Poor Commit Messages
❌ Avoid these:
```bash
git commit -m "fix"
git commit -m "working on stuff"
git commit -m "commit"
git commit -m "changes"
git commit -m "idk whatever"
```

---

## Branching for Individual Work

### Why Use Branches?
- Keep experimental work separate from working code
- Easily switch between different features
- Safely try different approaches without breaking main code

### Basic Branch Commands
```bash
# List all branches
git branch

# Create a new branch
git branch feature-branch-name

# Switch to a branch
git checkout feature-branch-name

# Create and switch to new branch in one command
git checkout -b feature-branch-name

# Switch back to main branch
git checkout main

# Delete a branch (after merging)
git branch -d feature-branch-name
```

### Recommended Branch Naming
- **lab1-implementation** - Working on Lab 1
- **avl-tree-rotations** - Implementing AVL rotations
- **hash-table-fix** - Fixing hash table bugs
- **performance-testing** - Adding benchmarking code
- **documentation-update** - Updating README and comments

### Individual Workflow with Branches
```bash
# Start working on a new feature
git checkout -b hash-table-implementation

# Work on your code, make commits as usual
git add .
git commit -m "feat: add basic hash table structure"

# Continue working and committing
git add .
git commit -m "feat: implement put() and get() methods"

# When feature is complete, switch to main
git checkout main

# Merge your feature branch
git merge hash-table-implementation

# Push the updated main branch
git push

# Clean up - delete the feature branch
git branch -d hash-table-implementation
```

---

## Team Project Workflow

### Before Starting Work
```bash
# Always pull latest changes before starting
git pull

# Create a branch for your work
git checkout -b your-name-feature-description
```

### While Working
```bash
# Make small, frequent commits
git add .
git commit -m "feat: implement BST insertion method"

# Push your branch regularly (backup)
git push -u origin your-branch-name
```

### When Feature is Complete
```bash
# Switch to main and pull latest
git checkout main
git pull

# Merge your branch
git merge your-branch-name

# Test everything still works
# Run all tests, compile, etc.

# Push to remote
git push

# Delete your feature branch
git branch -d your-branch-name
git push origin --delete your-branch-name
```

---

## Repository Submission Process

### For Labs (Individual Work)

**Setup:**
```bash
# Create your lab repository
mkdir lab1-lastname-firstname
cd lab1-lastname-firstname
git init

# Create your project structure
mkdir -p src/main/java src/test/java

# Add initial files
git add .
git commit -m "initial: set up lab1 project structure"
```

**During Development:**
```bash
# Regular workflow
git add .
git commit -m "feat: implement ArrayList constructor and add method"

# Continue with more commits...
git add .
git commit -m "test: add unit tests for ArrayList basic operations"

# Final commit
git add .
git commit -m "docs: complete README with compilation instructions"
```

**Submission:**
```bash
# Final verification
git status    # Should show clean working directory
git log --oneline    # Review your commit history

# Create submission zip
# (Include .git folder to show commit history)
cd ..
zip -r Lab1_Lastname_Firstname.zip lab1-lastname-firstname/
```

### For Team Projects

**Initial Setup:**
```bash
# Clone team repository
git clone https://github.com/teamname/data-structures-project.git
cd data-structures-project

# Verify team members
git log --oneline --all --graph
```

**Milestone Submissions:**
```bash
# Coordinate with team before submission
git checkout main
git pull

# Create milestone tag
git tag -a milestone1-v1.0 -m "Milestone 1: Core DS Library - Final Submission

- Implemented LinkedList, Stack, and Queue
- Comprehensive unit tests with 85% coverage  
- Complete design documentation
- All team members contributed"

# Push tag to remote
git push origin milestone1-v1.0

# Verify tag exists
git tag -l
```

---

## Common Git Scenarios

### Undoing Changes

**Undo changes to a file (before staging):**
```bash
git checkout -- filename.java
```

**Unstage a file:**
```bash
git reset filename.java
```

**Undo last commit (keep changes):**
```bash
git reset --soft HEAD~1
```

**Undo last commit (lose changes - careful!):**
```bash
git reset --hard HEAD~1
```

### Fixing Mistakes

**Fix last commit message:**
```bash
git commit --amend -m "New commit message"
```

**Add files to last commit:**
```bash
git add forgotten-file.java
git commit --amend --no-edit
```

### Working with Remote Repositories

**Check remote repository URL:**
```bash
git remote -v
```

**Change remote URL:**
```bash
git remote set-url origin https://github.com/username/new-repo.git
```

---

## Troubleshooting Common Issues

### Merge Conflicts
When Git can't automatically merge changes:

```bash
# Git will show conflict markers in files
# Edit conflicted files to resolve conflicts
# Look for these markers:
<<<<<<< HEAD
Your changes
=======
Their changes
>>>>>>> branch-name

# After resolving conflicts:
git add .
git commit -m "resolve: merge conflict in ClassName.java"
```

### Forgot to Pull Before Starting Work
```bash
# If you have local commits that conflict:
git pull --rebase

# This replays your commits on top of the latest changes
# May need to resolve conflicts during rebase
```

### Accidentally Committed Large Files
```bash
# Remove file from last commit
git rm --cached large-file.jar
git commit --amend --no-edit

# Add to .gitignore to prevent future commits
echo "*.jar" >> .gitignore
git add .gitignore
git commit -m "chore: add jar files to gitignore"
```

---

## Quick Reference Card

### Daily Commands
```bash
git status           # Check status
git add .           # Stage all changes
git commit -m "msg" # Commit with message
git push            # Upload changes
git pull            # Download updates
```

### Branch Commands
```bash
git branch                    # List branches
git checkout -b branch-name   # Create and switch
git checkout main            # Switch to main
git merge branch-name        # Merge branch
git branch -d branch-name    # Delete branch
```

### Information Commands
```bash
git log --oneline    # View commit history
git diff            # See changes
git remote -v       # Check remote URL
```

### Emergency Commands
```bash
git checkout -- file.java    # Undo file changes
git reset --soft HEAD~1       # Undo last commit
git commit --amend           # Fix last commit
```

---

## Course-Specific Notes

### For Lab Submissions
- Create meaningful commit messages showing your development process
- Include .git folder in your submission zip to show commit history
- Tag final versions: `git tag lab1-final`

### For Team Projects  
- Coordinate with teammates before pushing to main
- Use branches for major features
- Create milestone tags for project submissions
- Review teammate's code before merging

### Best Practices
- Commit early and often (but make each commit meaningful)
- Write commit messages that explain WHY, not just WHAT
- Always test your code before pushing
- Pull before starting new work
- Keep commit history clean and readable

**Remember:** Good version control habits are essential for professional software development. Practice these workflows now to build skills you'll use throughout your career!