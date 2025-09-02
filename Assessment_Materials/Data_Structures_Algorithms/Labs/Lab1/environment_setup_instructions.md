# Environment Setup Guide
## CSC 220: Data Structures & Algorithms

This guide will help you set up a professional Java development environment for the course. Follow the instructions for your operating system and preferred IDE.

---

## Overview of Required Software
- **Java JDK 17 or later** - The Java Development Kit
- **IDE**: IntelliJ IDEA Community Edition (recommended) or VS Code with Java extensions
- **Git** - Version control system for team collaboration
- **Terminal/Command Prompt** - For running commands

**Estimated Setup Time:** 30-45 minutes

---

## Step 1: Java JDK Installation

### Windows Installation

**Option 1: Oracle JDK (Recommended)**
1. Visit [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/)
2. Click **Windows** tab, then download **x64 Installer**
3. Run the installer with administrator privileges
4. Follow installation wizard (accept defaults)
5. **Verify installation:**
   ```cmd
   java -version
   javac -version
   ```

**Option 2: OpenJDK (Alternative)**
1. Visit [Microsoft OpenJDK](https://docs.microsoft.com/en-us/java/openjdk/download)
2. Download **OpenJDK 17 LTS - Windows x64**
3. Run installer and follow prompts
4. Verify installation as above

**Setting JAVA_HOME (if needed):**
1. Open **System Properties** → **Advanced** → **Environment Variables**
2. Click **New** under System Variables
3. Variable name: `JAVA_HOME`
4. Variable value: Path to JDK (e.g., `C:\Program Files\Java\jdk-17`)
5. Add `%JAVA_HOME%\bin` to your PATH variable

### macOS Installation

**Option 1: Oracle JDK**
1. Visit [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/)
2. Click **macOS** tab, download **ARM64 DMG Installer** (Apple Silicon) or **x64 DMG Installer** (Intel)
3. Double-click the downloaded `.dmg` file
4. Run the installer package
5. **Verify installation:**
   ```bash
   java -version
   javac -version
   ```

**Option 2: Homebrew (Recommended for experienced users)**
1. Install Homebrew if not already installed:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
2. Install OpenJDK:
   ```bash
   brew install openjdk@17
   ```
3. Link the JDK:
   ```bash
   sudo ln -sfn /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk
   ```

### Linux Installation (Ubuntu/Debian)

**Using Package Manager:**
```bash
# Update package index
sudo apt update

# Install OpenJDK 17
sudo apt install openjdk-17-jdk

# Verify installation
java -version
javac -version
```

**Setting JAVA_HOME:**
```bash
# Add to ~/.bashrc or ~/.zshrc
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin

# Reload shell configuration
source ~/.bashrc
```

---

## Step 2: IDE Setup

### Option A: IntelliJ IDEA Community Edition (Recommended)

**Why IntelliJ?**
- Excellent Java support out of the box
- Powerful debugging and profiling tools
- Built-in Git integration
- Industry standard for Java development

**Installation:**

**Windows:**
1. Visit [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
2. Click **Download** under **Community Edition** (free)
3. Run the installer
4. **Important checkboxes during installation:**
   - ☑️ Create Desktop Shortcut
   - ☑️ Add "bin" folder to PATH
   - ☑️ Associate .java files with IntelliJ IDEA

**macOS:**
1. Download **Community Edition** from [JetBrains website](https://www.jetbrains.com/idea/download/)
2. Drag IntelliJ IDEA to Applications folder
3. Launch from Applications

**Linux:**
1. Download the **Community Edition** tar.gz file
2. Extract to your preferred location:
   ```bash
   tar -xzf ideaIC-*.tar.gz -C /opt/
   ```
3. Run the installation:
   ```bash
   cd /opt/idea-IC-*/bin
   ./idea.sh
   ```

**Initial Setup:**
1. **First Launch:** Choose "Do not import settings"
2. **UI Theme:** Select your preference (Darcula or Light)
3. **Featured Plugins:** Keep defaults, click **Start using IntelliJ IDEA**
4. **Create Test Project:**
   - Click **New Project**
   - Select **Java** → **Next** → **Next**
   - Name: "TestProject" → **Finish**
   - Create a new Java class and test compilation

### Option B: VS Code with Java Extensions

**Why VS Code?**
- Lightweight and fast
- Excellent extension ecosystem
- Great for multiple programming languages
- Free and open source

**Installation:**

**Windows/macOS/Linux:**
1. Download VS Code from [code.visualstudio.com](https://code.visualstudio.com/)
2. Install using the downloaded installer
3. Launch VS Code

**Essential Java Extensions:**
1. Open VS Code
2. Click **Extensions** (Ctrl+Shift+X)
3. Search and install **"Extension Pack for Java"** by Microsoft
   - This includes:
     - Language Support for Java
     - Debugger for Java
     - Test Runner for Java
     - Maven for Java
     - Project Manager for Java
     - Visual Studio IntelliCode

**Additional Recommended Extensions:**
- **Git Graph** - Visual git history
- **GitLens** - Enhanced git integration  
- **Bracket Pair Colorizer** - Visual bracket matching
- **Code Spell Checker** - Catches typos in code

**VS Code Java Configuration:**
1. **Open Settings** (Ctrl+,)
2. Search "java home"
3. Set **Java › Configuration: Runtimes** to your JDK path
4. **Test Setup:**
   - Create new folder for test project
   - Open folder in VS Code (File → Open Folder)
   - Create `HelloWorld.java`:
     ```java
     public class HelloWorld {
         public static void main(String[] args) {
             System.out.println("Hello, World!");
         }
     }
     ```
   - Press F5 to run and debug

---

## Step 3: Git Installation and Configuration

### Git Installation

**Windows:**
1. Download from [git-scm.com](https://git-scm.com/download/win)
2. Run installer with these recommended settings:
   - ☑️ Use Git from the Windows Command Prompt
   - ☑️ Checkout Windows-style, commit Unix-style line endings
   - ☑️ Use MinTTY terminal
   - ☑️ Enable file system caching

**macOS:**
```bash
# Using Homebrew (recommended)
brew install git

# Or download from git-scm.com
```

**Linux:**
```bash
# Ubuntu/Debian
sudo apt install git

# CentOS/RHEL
sudo yum install git
```

### Git Configuration

**Set up your identity:**
```bash
git config --global user.name "Your Full Name"
git config --global user.email "your.email@gwu.edu"
```

**Configure default branch name:**
```bash
git config --global init.defaultBranch main
```

**Set up credential storage:**
```bash
# Windows
git config --global credential.helper manager-core

# macOS
git config --global credential.helper osxkeychain

# Linux
git config --global credential.helper store
```

**Verify configuration:**
```bash
git config --list
```

### GitHub Setup (for course repositories)

1. **Create GitHub account** (if you don't have one)
2. **Generate SSH key** (recommended for authentication):
   ```bash
   ssh-keygen -t ed25519 -C "your.email@gwu.edu"
   ```
   - Press Enter to save to default location
   - Enter a secure passphrase (recommended)

3. **Add SSH key to GitHub:**
   ```bash
   # Copy public key to clipboard
   # Windows
   clip < ~/.ssh/id_ed25519.pub
   
   # macOS
   pbcopy < ~/.ssh/id_ed25519.pub
   
   # Linux
   cat ~/.ssh/id_ed25519.pub
   ```
   - Go to GitHub → Settings → SSH and GPG keys
   - Click "New SSH key"
   - Paste your key and save

4. **Test SSH connection:**
   ```bash
   ssh -T git@github.com
   ```

---

## Step 4: Verification Checklist

Run these commands to verify everything is working:

```bash
# Java verification
java -version        # Should show Java 17 or later
javac -version       # Should show Java 17 or later

# Git verification  
git --version        # Should show Git 2.30 or later
git config user.name # Should show your name
git config user.email # Should show your email

# GitHub SSH test
ssh -T git@github.com # Should authenticate successfully
```

**IDE Verification:**
- Create a new Java project
- Write and compile a simple "Hello World" program
- Run the program successfully
- Test Git integration (clone a repository or init a new one)

---

## Troubleshooting

### Java Issues

**"java" or "javac" command not found:**
- **Windows:** Add Java to PATH in Environment Variables
- **macOS/Linux:** Add `export PATH=$PATH:$JAVA_HOME/bin` to your shell profile

**Multiple Java versions installed:**
```bash
# Check all installed versions (macOS)
/usr/libexec/java_home -V

# Set specific version (macOS)
export JAVA_HOME=$(/usr/libexec/java_home -v 17)

# Check alternatives (Linux)
sudo update-alternatives --config java
```

### IntelliJ IDEA Issues

**Project won't compile:**
1. File → Project Structure → Project Settings → Project
2. Verify Project SDK is set to Java 17+
3. Set Project language level to "17 - Sealed types, always strict floating-point..."

**Git integration not working:**
1. File → Settings → Version Control → Git
2. Verify "Path to Git executable" points to correct git installation

### VS Code Issues

**Java extension not activating:**
1. Check Java is properly installed (`java -version`)
2. Open Command Palette (Ctrl+Shift+P)
3. Run "Java: Reload Projects"
4. Check Output → Java for error messages

**Debugger not working:**
1. Ensure you have a `main` method in your class
2. Click in the gutter to set breakpoints
3. Press F5 to start debugging
4. Check launch.json configuration if issues persist

### Git Issues

**Authentication failures:**
```bash
# Check credential helper
git config credential.helper

# Clear stored credentials (Windows)
git config --global --unset credential.helper

# Reset SSH connection
ssh-add -D
ssh-add ~/.ssh/id_ed25519
```

**Permission denied (SSH):**
1. Verify SSH key is added to GitHub
2. Test connection: `ssh -T git@github.com`
3. Check SSH agent is running: `ssh-add -l`

**Line ending issues:**
```bash
# Configure line endings globally
git config --global core.autocrlf true  # Windows
git config --global core.autocrlf input # macOS/Linux
```

---

## Getting Additional Help

### Course Resources
- **TA Office Hours:** Monday/Wednesday 4:00-6:00 PM in SEAS Lab 201
- **Course Discord:** #technical-help channel
- **Instructor Office Hours:** Tuesday/Thursday 1:00-3:00 PM

### External Resources
- **IntelliJ IDEA Learning:** [JetBrains Academy](https://www.jetbrains.com/academy/)
- **VS Code Java Tutorial:** [Microsoft Learn](https://docs.microsoft.com/en-us/learn/modules/java-get-started/)
- **Git Tutorial:** [Git Handbook](https://guides.github.com/introduction/git-handbook/)
- **Java Documentation:** [Oracle Java Docs](https://docs.oracle.com/en/java/)

### Platform-Specific Help
- **Windows:** Use PowerShell or Command Prompt as administrator for installations
- **macOS:** Install Xcode Command Line Tools if you encounter compilation issues
- **Linux:** Your package manager is usually the best way to install development tools

---

## Quick Reference Commands

### Essential Git Commands
```bash
git clone <repository-url>  # Download repository
git status                  # Check repository status  
git add .                   # Stage all changes
git commit -m "message"     # Commit with message
git push                    # Upload changes
git pull                    # Download updates
```

### Java Compilation
```bash
# Compile single file
javac HelloWorld.java

# Compile with classpath
javac -cp ".:lib/*" *.java

# Run program
java HelloWorld

# Run with classpath
java -cp ".:lib/*" HelloWorld
```

**Remember:** A properly configured development environment is crucial for success in this course. Take time to set everything up correctly – it will save you hours of frustration later!