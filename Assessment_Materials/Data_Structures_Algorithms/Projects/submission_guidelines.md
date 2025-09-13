# Submission Guidelines
## CSC 220: Data Structures & Algorithms - Semester Project

---

## Overview

This document provides detailed instructions for submitting project milestones, including naming conventions, repository requirements, file organization, and submission procedures. Following these guidelines ensures consistent evaluation and helps maintain professional development practices.

**Core Principle:** Professional software development requires consistent documentation, version control, and delivery practices. These guidelines mirror industry standards while supporting academic evaluation needs.

---

## Repository Structure and Organization

### Required Repository Structure
```
team-[number]-data-structures/
├── README.md
├── .gitignore
├── .gitattributes
├── build.gradle (or pom.xml/setup.py)
├── docs/
│   ├── milestone1/
│   │   ├── design_document.pdf
│   │   ├── uml_diagrams.pdf
│   │   └── complexity_analysis.pdf
│   ├── milestone2/
│   │   ├── benchmark_results.pdf
│   │   ├── performance_analysis.pdf
│   │   └── uml_class_hierarchy.pdf
│   └── milestone3/
│       ├── final_report.pdf
│       ├── architecture_overview.pdf
│       └── presentation_slides.pdf
├── src/
│   ├── main/
│   │   └── [language]/
│   │       └── datastructures/
│   │           ├── linear/
│   │           ├── trees/
│   │           ├── hashing/
│   │           └── utils/
│   └── test/
│       └── [language]/
│           └── datastructures/
│               ├── linear/
│               ├── trees/
│               └── hashing/
├── benchmarks/
│   ├── BenchmarkSuite.java (or .py)
│   ├── results/
│   │   ├── milestone2_results.csv
│   │   └── performance_charts.png
│   └── scripts/
└── examples/
    ├── demo_applications/
    └── usage_samples/
```

### File Naming Conventions

#### Source Code Files
- **Java:** PascalCase for classes (`LinkedList.java`, `AVLTree.java`)
- **Python:** snake_case for modules (`linked_list.py`, `avl_tree.py`)
- **Interfaces:** Clear interface naming (`List.java`, `Tree.java`)
- **Tests:** Append "Test" to class name (`LinkedListTest.java`)

#### Documentation Files
- **Design Documents:** `milestone[X]_design_document.pdf`
- **Reports:** `milestone[X]_[report_type].pdf`
- **README Files:** `README.md` (main) or `milestone[X]_README.md`
- **UML Diagrams:** `milestone[X]_uml_[diagram_type].pdf`

#### Data and Results Files
- **Benchmark Results:** `milestone[X]_benchmark_results.csv`
- **Performance Data:** `milestone[X]_performance_[test_type].csv`
- **Charts and Graphs:** `milestone[X]_[chart_type]_chart.png`

---

## Git Repository Requirements

### Branch Strategy
```
main (or master)
├── milestone1-dev
├── milestone2-dev
├── milestone3-dev
└── feature branches (optional)
```

#### Main Branch
- **Purpose:** Stable, working code only
- **Protection:** Only merge through pull requests
- **History:** Clean commit history with descriptive messages
- **Tags:** Required for each milestone submission

#### Development Branches
- **Naming:** `milestone[X]-dev` (e.g., `milestone1-dev`)
- **Purpose:** Active development for specific milestone
- **Merging:** Merge to main when milestone complete and tested
- **Cleanup:** Delete after successful merge (optional)

### Commit Message Standards
```
Type: Brief description (50 characters max)

Longer explanation if needed (wrap at 72 characters)
- Bullet points for multiple changes
- Reference issue numbers if applicable

Examples:
feat: Add AVL tree rotation algorithms
fix: Resolve hash table collision handling bug  
docs: Update README with build instructions
test: Add comprehensive BST deletion tests
refactor: Optimize linked list traversal performance
```

#### Commit Types
- **feat:** New features or major functionality
- **fix:** Bug fixes and error corrections
- **docs:** Documentation changes only
- **test:** Test additions or modifications
- **refactor:** Code restructuring without feature changes
- **style:** Formatting and code style changes
- **perf:** Performance improvements

### Tagging Requirements

#### Milestone Tags
**Format:** `milestone[X]-v[Y.Z]`
- `milestone1-v1.0` - Initial Milestone 1 submission
- `milestone1-v1.1` - Bug fix after initial submission
- `milestone2-v1.0` - Initial Milestone 2 submission

#### Tag Creation
```bash
# Create annotated tag with description
git tag -a milestone1-v1.0 -m "Milestone 1: Core DS Library - Initial Submission"

# Push tags to remote repository
git push origin --tags
```

#### Tag Requirements
- **Required:** One tag per milestone marking final submission
- **Timing:** Must be created before submission deadline
- **Content:** Tag must point to working, tested code
- **Description:** Include milestone name and brief description

---

## Submission Procedures

### Dual Submission System
All milestone deliverables require **both** repository submission and LMS submission:

1. **GitHub Repository:** Source code, documentation, and version history
2. **Course LMS:** Formal submission with timestamp and team information

### Step-by-Step Submission Process

#### Step 1: Pre-Submission Checklist
- [ ] All code compiles successfully without warnings
- [ ] All tests pass (minimum 80% coverage for relevant milestones)
- [ ] Documentation complete and properly formatted
- [ ] Repository structure follows required organization
- [ ] Commit history is clean with descriptive messages
- [ ] All team members have contributed and are listed

#### Step 2: Repository Finalization
```bash
# 1. Ensure all changes are committed
git status
git add .
git commit -m "final: Complete milestone[X] submission"

# 2. Merge to main branch
git checkout main
git merge milestone[X]-dev

# 3. Create submission tag
git tag -a milestone[X]-v1.0 -m "Milestone [X] final submission"

# 4. Push everything to remote
git push origin main
git push origin --tags
```

#### Step 3: LMS Submission Package
Create a submission package containing:

**Required Files:**
- `team_[number]_milestone[X]_submission.pdf` (cover sheet)
- Links to GitHub repository and specific commit/tag
- Individual contribution statements
- Peer evaluation forms (if due)

**Submission Package Template:**
```
Team [Number] - Milestone [X] Submission
=====================================

Team Members:
- [Name 1] ([Role]) - [Email] - [GitHub Username]
- [Name 2] ([Role]) - [Email] - [GitHub Username]  
- [Name 3] ([Role]) - [Email] - [GitHub Username]
- [Name 4] ([Role]) - [Email] - [GitHub Username]

Repository Information:
- GitHub URL: https://github.com/[username]/[repository]
- Submission Tag: milestone[X]-v1.0
- Commit Hash: [full commit hash]
- Submission Date: [YYYY-MM-DD HH:MM]

Deliverables Checklist:
□ Source code implementation
□ Unit tests with coverage report
□ Design documentation
□ Performance analysis (if required)
□ README with build/run instructions
□ Individual contribution statements

Individual Contributions:
[Each team member provides 100-150 word summary of their contributions]

Compilation Instructions:
[Specific commands to build and run the project]

Known Issues:
[Any bugs or limitations that evaluators should be aware of]
```

#### Step 4: LMS Upload
1. **Access Course LMS:** Navigate to appropriate milestone submission area
2. **Upload Files:** Include submission package and any required documents
3. **Repository Link:** Provide clickable link to GitHub repository
4. **Verification:** Confirm all files uploaded successfully
5. **Submit:** Click final submit button (note timestamp)

---

## Code Quality Requirements

### General Standards
- **Compilation:** Code must compile without errors or warnings
- **Functionality:** All required features must be implemented and working
- **Testing:** Comprehensive test coverage (≥80% where specified)
- **Documentation:** Clear comments and documentation for all public interfaces

### Language-Specific Requirements

#### Java Projects
```java
// File header required
/**
 * [Class Description]
 * CSC 220 - Data Structures & Algorithms
 * Milestone [X] - [Component Name]
 * 
 * @author Team [Number]: [Names]
 * @version [Date]
 */

// JavaDoc required for all public methods
/**
 * Inserts an element at the specified position.
 * 
 * @param index the position to insert at (0-based)
 * @param element the element to insert
 * @throws IndexOutOfBoundsException if index is invalid
 */
public void insert(int index, T element) {
    // Implementation
}
```

#### Python Projects
```python
"""
[Module Description]
CSC 220 - Data Structures & Algorithms  
Milestone [X] - [Component Name]

Authors: Team [Number]: [Names]
Version: [Date]
"""

class LinkedList:
    """A singly linked list implementation.
    
    This class provides basic linked list operations including
    insertion, deletion, and traversal.
    """
    
    def insert(self, index: int, element) -> None:
        """Insert an element at the specified position.
        
        Args:
            index: The position to insert at (0-based)
            element: The element to insert
            
        Raises:
            IndexError: If index is out of bounds
        """
        # Implementation
```

### Build System Requirements

#### Java (Gradle Example)
```gradle
// build.gradle
plugins {
    id 'java'
    id 'jacoco'
}

group = 'edu.gwu.cs220'
version = '1.0.0'
sourceCompatibility = '11'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'junit:junit:4.13.2'
    testImplementation 'org.hamcrest:hamcrest:2.2'
}

test {
    useJUnit()
    finalizedBy jacocoTestReport
}

jacocoTestReport {
    reports {
        xml.enabled false
        csv.enabled false
        html.destination file("${buildDir}/jacocoHtml")
    }
}
```

#### Python (setup.py Example)
```python
from setuptools import setup, find_packages

setup(
    name="team-[number]-datastructures",
    version="1.0.0",
    packages=find_packages(where="src"),
    package_dir={"": "src"},
    python_requires=">=3.8",
    install_requires=[
        "pytest>=6.0",
        "pytest-cov>=2.0",
    ],
    author="Team [Number]",
    description="Data Structures & Algorithms Course Project"
)
```

---

## Documentation Requirements

### README.md Template
```markdown
# Team [Number] - Data Structures & Algorithms Project

## Team Members
- **[Name 1]** ([@username]) - [Role] - [Email]
- **[Name 2]** ([@username]) - [Role] - [Email]  
- **[Name 3]** ([@username]) - [Role] - [Email]
- **[Name 4]** ([@username]) - [Role] - [Email]

## Project Overview
[Brief description of project goals and current milestone]

## Quick Start

### Prerequisites
- [Language] [Version]
- [Build tool] [Version]
- [Other dependencies]

### Building the Project
```bash
[Specific build commands]
```

### Running Tests
```bash
[Test execution commands with coverage]
```

### Running Examples/Demos
```bash
[Commands to run sample applications]
```

## Project Structure
[Explanation of directory organization and key files]

## Implementation Status
- [x] Completed Feature 1
- [x] Completed Feature 2  
- [ ] In Progress Feature 3
- [ ] Planned Feature 4

## Known Issues
[Any bugs or limitations]

## Documentation
- [Link to design documents]
- [Link to performance analysis]
- [Link to API documentation]

## Milestone Progress
### Milestone 1 (Due Week 6) - Status: [Complete/In Progress]
[Brief summary of milestone 1 deliverables and status]

### Milestone 2 (Due Week 11) - Status: [Complete/In Progress]  
[Brief summary of milestone 2 deliverables and status]

### Milestone 3 (Due Week 16) - Status: [Complete/In Progress]
[Brief summary of milestone 3 deliverables and status]

## License
Educational use only - CSC 220 Course Project
```

### Individual Contribution Statements
**Required for each milestone submission:**

```
Individual Contribution Statement - Milestone [X]
==============================================

Name: [Your Name]
Role This Milestone: [Role Title]
Date: [Submission Date]

Summary of Contributions (100-150 words):
[Describe your specific contributions to this milestone, including:
- Code components you implemented
- Documentation you wrote or edited  
- Testing you performed
- Design decisions you led
- Debugging or problem-solving you performed
- Team coordination or communication you facilitated]

Time Investment:
- Total hours worked: [Estimated hours]
- Breakdown by activity:
  * Design/Planning: [hours]
  * Implementation: [hours]
  * Testing/Debugging: [hours]
  * Documentation: [hours]
  * Team coordination: [hours]

Challenges Faced:
[Describe 1-2 main challenges and how you addressed them]

Learning Outcomes:
[What new skills or knowledge did you gain from this milestone?]

Next Milestone Preparation:
[What do you plan to focus on for the next milestone?]
```

---

## Quality Assurance Checklist

### Pre-Submission Testing
- [ ] **Clean Build:** Project builds successfully from scratch
- [ ] **All Tests Pass:** No failing unit tests or integration tests
- [ ] **Coverage Requirements:** Meet minimum coverage thresholds
- [ ] **No Warnings:** Compilation produces no warnings
- [ ] **Memory Safety:** No memory leaks or dangerous operations
- [ ] **Performance:** Meets expected algorithmic complexity

### Documentation Review
- [ ] **README Complete:** All required sections filled out
- [ ] **Code Comments:** Public interfaces documented
- [ ] **Design Documents:** All required documents present and complete
- [ ] **File Organization:** Repository structure matches requirements
- [ ] **Spelling/Grammar:** Documents proofread and professional

### Repository Hygiene
- [ ] **Commit History:** Clean, descriptive commit messages
- [ ] **Branch Strategy:** Proper use of branches and merging
- [ ] **Tag Creation:** Milestone tag created and pushed
- [ ] **File Cleanup:** No unnecessary files (build artifacts, IDE files)
- [ ] **.gitignore Proper:** Appropriate files excluded from repository

---

## Common Submission Issues and Solutions

### Issue: "Repository doesn't build on instructor machine"
**Solution:**
- Include all necessary dependencies in build file
- Test build on fresh environment (different computer)
- Provide clear build instructions in README
- Use relative paths, not absolute paths

### Issue: "Missing or incorrect file organization"
**Solution:**
- Follow repository structure template exactly
- Use provided directory structure as checklist
- Ensure file names match required conventions
- Check that all deliverables are in correct locations

### Issue: "Git history is messy or unclear"
**Solution:**
- Use descriptive commit messages following standards
- Squash related commits if necessary
- Ensure each commit represents logical change
- Include all team member contributions in history

### Issue: "Documentation doesn't match implementation"
**Solution:**
- Review all documentation before submission
- Verify code examples in documentation work
- Ensure design documents reflect actual implementation
- Cross-check complexity analysis with actual code

### Issue: "Late submission due to technical problems"
**Solution:**
- Start submission process early (24-48 hours before deadline)
- Test full submission process during development
- Keep backup copies of all work
- Contact instructor immediately if problems arise

---

## Submission Deadlines and Timeline

### Milestone Submission Calendar
| Milestone | Due Date | Submission Window | Late Penalty Starts |
|-----------|----------|-------------------|---------------------|
| Milestone 1 | End of Week 6 | Friday 11:59 PM | Saturday 12:00 AM |
| Milestone 2 | End of Week 11 | Friday 11:59 PM | Saturday 12:00 AM |
| Milestone 3 | End of Week 16 | Friday 11:59 PM | Saturday 12:00 AM |

### Recommended Submission Timeline
**Week of Deadline:**
- **Monday-Tuesday:** Code finalization and testing
- **Wednesday:** Documentation completion and review
- **Thursday:** Repository cleanup and pre-submission testing
- **Friday Morning:** Final submission package preparation
- **Friday Afternoon:** Dual submission (GitHub + LMS)

### Emergency Procedures
**If technical issues arise near deadline:**
1. **Document the problem:** Screenshots, error messages
2. **Contact instructor immediately:** Don't wait until after deadline
3. **Submit what you have:** Partial submission better than none
4. **Follow up promptly:** Provide additional context as soon as possible

---

## Frequently Asked Questions

### Q: Can we reorganize the repository structure?
**A:** The basic structure must be followed, but you can add subdirectories within the required directories. Any major changes should be approved by the instructor first.

### Q: What if our team size is different from 4 people?
**A:** Adjust individual contribution statements accordingly. 3-person teams should note the increased workload per person; 5+ person teams should ensure everyone has meaningful contributions.

### Q: Can we submit multiple times?
**A:** Yes, you can resubmit before the deadline. The latest submission (based on LMS timestamp) will be graded. Use version numbers in your tags to track multiple submissions.

### Q: What file formats are required for documents?
**A:** PDFs for all formal documents (reports, design docs). README files should be Markdown (.md). Code should be in specified language extensions.

### Q: How detailed should commit messages be?
**A:** Brief but descriptive. The first line should summarize the change in 50 characters or less. Add more detail in the body if the change is complex.

---

## Getting Help

### Technical Support
- **Office Hours:** Tuesday/Thursday 1:00-3:00 PM
- **TA Lab Hours:** Monday/Wednesday 4:00-6:00 PM  
- **Course Discord:** #submission-help channel
- **Email:** jpaiz@gwu.edu (for urgent issues)

### Process Questions
- **Submission procedures:** Ask during class or office hours
- **Repository organization:** Examples available in course materials
- **Documentation standards:** Templates provided for each milestone
- **Quality requirements:** Rubrics detail all expectations

Remember: Following these guidelines carefully ensures fair evaluation and demonstrates professional software development practices. When in doubt, ask for clarification rather than making assumptions!