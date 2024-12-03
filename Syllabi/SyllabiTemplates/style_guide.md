# Syllabus Style Guide
## For Computer Science Course Documentation

### Document Structure and Formatting

#### Markdown Conventions
- Use ATX-style headers (`#` for headers) rather than underlines
- Maximum header depth of 3 levels for readability
- Use blank lines before and after headers
- Use `-` for unordered lists, `1.` for ordered lists

#### Headers
```markdown
# Course Title (H1)
## Section Headers (H2)
### Subsection Headers (H3)
```

#### Text Formatting
- Bold (`**`) for emphasis of important information
- Italics (`*`) for definitions or key terms
- Code blocks (`` ` ``) for technical terms or commands
- Use tables for structured information (grades, schedules)

#### Spacing
- Single blank line between paragraphs
- Double blank line between major sections
- No trailing whitespace
- Consistent indentation (2 spaces) for nested lists

### Language and Style Guidelines

#### Voice and Tone
- Use third person for policies and requirements
  - ✅ "Students will submit assignments..."
  - ❌ "You will submit assignments..."
- Use first person plural for collaborative aspects
  - ✅ "We will explore concepts..."
  - ❌ "I will teach you concepts..."
- Maintain professional but approachable language

#### Learning Objectives
- Begin with "After completing this course, students will be able to:"
- Use measurable action verbs (Bloom's Taxonomy)
  - ✅ "implement", "analyze", "design"
  - ❌ "understand", "know", "learn"
- Focus on demonstrable skills

#### Standard Terminology
Course Components:
- "Assignment" for individual tasks
- "Project" for larger, multi-step work
- "Lab" for hands-on practice sessions
- "Assessment" for tests/quizzes

Technical Terms:
- Capitalize proper programming languages
- Use standard industry abbreviations
- Include brief definitions for technical terms

### Policy Templates

#### Academic Integrity
Standard opening:
```markdown
Academic integrity is fundamental to the learning process. Any form of cheating or plagiarism will result in disciplinary action. For programming assignments:

- Code sharing must follow collaboration guidelines
- Use of AI tools must be documented
- External code must be cited
```

#### Late Work Policy
Standard template:
```markdown
Assignment submissions are due by [time] on the specified due date. Late submissions will:

- Receive a 10% penalty per day late
- Not be accepted after 3 days
- Require documentation for extensions
```

#### Attendance Policy
Standard template:
```markdown
Regular attendance is essential for success in this course. Students are expected to:

- Attend all scheduled sessions
- Arrive on time and prepared
- Notify instructor in advance of absences
```

### Course-Specific Adaptations

#### Introduction Level Courses
- Include more detailed explanations
- Provide specific examples
- List prerequisite knowledge explicitly
- Include study tips and resources

#### Advanced Courses
- Focus on learning objectives
- Include research/industry connections
- Reference advanced resources
- Detail project expectations

#### Lab Courses
Additional sections:
- Lab safety rules
- Equipment usage policies
- Partner/group work guidelines
- Lab report requirements

#### Online/Hybrid Courses
Additional sections:
- Technology requirements
- Online participation expectations
- Virtual meeting protocols
- Digital submission guidelines

### Version Control and Change Documentation

#### Last Updated Date
- Format as: `Last Updated: YYYY-MM-DD`
- Place at bottom of document
- Include in both syllabus and changelog
- Example: `Last Updated: 2024-01-15`

#### Documenting Major Changes
- Record all substantive changes, including:
  - Policy modifications
  - Schedule adjustments
  - Assignment weight changes
  - Required material updates
  - Learning objective revisions
- Do not record minor changes like:
  - Typo corrections
  - Formatting adjustments
  - Link updates
  - Clarifying language (without policy change)

#### Changelog Structure (changelog.md)
```markdown
# Changelog

All notable changes to this syllabus will be documented in this file.

## [1.1.0] - 2024-01-15
### Added
- New section on AI tool usage
- Additional office hours

### Changed
- Updated textbook to newer edition
- Modified project submission guidelines

### Removed
- Outdated software requirements

## [1.0.0] - 2023-12-01
### Initial Release
- Complete syllabus structure
- Core policies
- Course schedule
```

#### Semantic Versioning (X.Y.Z)
- **X (Major Version)**
  - Increment when making incompatible policy changes
  - Example: Changing grading scale, major assessment structure
  - Changes require department approval
  - Example: 1.0.0 → 2.0.0

- **Y (Minor Version)**
  - Increment when adding functionality in a backward-compatible manner
  - Example: Adding new resources, expanding policies
  - Changes that benefit students without disruption
  - Example: 1.0.0 → 1.1.0

- **Z (Patch Version)**
  - Increment for backward-compatible bug fixes
  - Example: Correcting dates, fixing broken links
  - Clarifying existing policies without changing them
  - Example: 1.1.0 → 1.1.1

Version Examples:
- 1.0.0: Initial approved syllabus
- 1.0.1: Fixed typos and clarified existing policies
- 1.1.0: Added new supplementary resources
- 2.0.0: Changed grading structure

### Accessibility Guidelines
- Use descriptive link text
- Provide alt text for images
- Use adequate color contrast
- Structure content hierarchically

### Review Checklist
Before finalizing any syllabus:
- [ ] All placeholder text replaced
- [ ] Dates and deadlines verified
- [ ] Links checked
- [ ] Policies align with institution
- [ ] Formatting consistent
- [ ] Spell-check completed
- [ ] Headers properly nested
- [ ] Tables properly formatted

---
Last Updated: 2024-12-03  
Version: 1.0.0  
[Change Log](./changelog.md)