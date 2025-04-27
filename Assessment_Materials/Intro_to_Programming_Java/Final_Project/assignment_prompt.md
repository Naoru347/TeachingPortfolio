# Final Project Assignment: Portfolio-Worthy Java Application

## Assignment Overview

The final project is your opportunity to apply what you’ve learned in this course by building a Java application with real-world relevance. To help guide you, we’ve provided starter code for three project options tailored to potential career paths: **Data Science**, **Computer Science and Engineering**, and **Cybersecurity**. You’ll implement core functionality, enhance the code with your ideas, and document your work to produce a polished project suitable for your portfolio.

---

## Project Options

### 1. Data Science: Data Analysis and Visualization Tool

**Starter Code:**  
The provided code will load a CSV file and display its contents in the terminal using Java I/O and a simple data model. The dataset may include weather data, sales figures, or other real-world examples.

**Your Tasks:**
- **Enhance Data Processing:**  
  Add at least two of the following features:
  - Filter data by criteria (e.g., date range, category, or value threshold).
  - Sort data by column (ascending or descending).
  - Aggregate data (e.g., averages, totals, counts).

- **Create Visualizations:**  
  Use a Java-compatible library such as **JFreeChart**, **JavaFX Charts**, or **XChart** to generate **at least two visualizations**, such as:
  - Bar charts.
  - Line graphs for trends over time.
  - Scatter plots.

- **Interactive Console Input:**  
  Add interactive command-line features to:
  - Allow users to select which dataset to analyze.
  - Let users choose visualization types or filtering options via menu prompts.

---

### 2. Computer Science and Engineering: Simulation or Algorithm Implementation

**Starter Code:**  
The provided code includes a Java class skeleton for a simulation, such as a traffic light system (using timers or threads) or a graph-based pathfinding problem using Java collections.

**Your Tasks:**
- **Implement Core Functionality:**  
  Based on your chosen scenario:
  - **Traffic light simulation:** Implement state changes (e.g., red, yellow, green) over time using timers or threads.
  - **Graph simulation:** Implement a graph structure and pathfinding algorithm (e.g., BFS or Dijkstra’s algorithm).

- **Add Customizable Features:**
  - Allow user-defined parameters such as:
    - Timing intervals or number of intersections (traffic sim).
    - Graph size, weights, start/end nodes (graph sim).
  - Add step-by-step or real-time visualization using **JavaFX** or console-based output.

- **Generate Output:**
  - Save a log file showing simulation steps or results.
  - Generate a visual graph of paths or system state transitions.

---

### 3. Cybersecurity: Secure Login and Encryption System

**Starter Code:**  
The starter code provides a basic login system that uses Java file I/O and stores usernames and passwords in plaintext.

**Your Tasks:**
- **Implement Secure Password Storage:**  
  Replace plaintext passwords with secure hashing using `java.security.MessageDigest` or external libraries like **BCrypt** (`org.mindrot.jbcrypt`).

- **Enhance System Features:**
  Add at least two of the following:
  - A registration system for new users.
  - Password recovery (e.g., using security questions or email simulation).
  - Multi-factor authentication (e.g., PIN or security question confirmation).

- **Improve Error Handling:**
  Handle:
  - Invalid/missing inputs.
  - Login failures.
  - Duplicate usernames or empty fields.

- **Secure Data Storage:**
  Store data using:
  - Structured text (e.g., JSON via `org.json` or `Gson`).
  - Serialized objects.
  - Encrypted files (optional advanced feature).

---

## What You’ll Submit

1. **Codebase:**
   - Modified starter code with your enhancements.
   - Organized project structure (e.g., `src/`, `data/`, `docs/`).

2. **README File:**
   - **Project Title**
   - **Description**
   - **Features Implemented**
   - **How to Run** (IDE or terminal instructions, any required libraries)
   - **Reflection** (connect project to your career goals)

3. **Reflection Paper (1 Page):**
   - Why you chose the project
   - Challenges and how you addressed them
   - Lessons learned and relevance to your future goals

4. **Presentation (Optional Bonus):**
   - Present your work live for extra credit.
   - Demonstrate your app and walk through its purpose and features.

---

## Grading Criteria

| **Category**              | **Weight** | **Description**                                                                                      |
|---------------------------|------------|------------------------------------------------------------------------------------------------------|
| **Core Functionality**    | 40%        | Required features implemented and working as expected.                                               |
| **Enhancements**          | 20%        | Effort and creativity in feature additions or improvements.                                          |
| **Documentation**         | 20%        | Clear README, inline code comments, organized structure.                                             |
| **Reflection**            | 10%        | Insightful analysis of challenges, learning, and career relevance.                                   |
| **Code Quality**          | 10%        | Adherence to Java best practices (naming, modularity, error handling, documentation).                |

---

## Timeline and Milestones

| **Week** | **Deliverable**                    | **Description**                                                                                   |
|----------|------------------------------------|---------------------------------------------------------------------------------------------------|
| Week 11  | **Project Kickoff**                | Starter code release. Explore project options and start brainstorming.                           |
| Week 12  | **Project Proposal**               | Submit a short form with selected option and planned enhancements.                                |
| Week 13  | **Code Walkthrough**               | In-class walkthrough of starter code and development roadmap.                                     |
| Week 14  | **Progress Check 1**               | Submit a partial version (core functionality complete) for feedback.                             |
| Week 15  | **Peer Review**                    | Share your project with a classmate and give/receive feedback.                                   |
| Week 16  | **Final Submission**               | Submit complete project (codebase, README, reflection).                                          |

---

**Starter code and additional tools will be distributed via the GitHub Classroom repository.**
