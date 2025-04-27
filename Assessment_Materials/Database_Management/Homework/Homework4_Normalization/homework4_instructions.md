# Homework Assignment 4: Normalization Practice

## Overview
This assignment gives you hands-on experience with the process of database normalization. You will receive unnormalized tables and work step-by-step to bring them into First Normal Form (1NF), Second Normal Form (2NF), and finally Third Normal Form (3NF). You’ll also explain your reasoning and the specific changes made at each stage.

---

## Assignment Instructions

### Step 1: Download the Unnormalized Tables
Download the provided file **Normalization_Practice_Tables.pdf** from the course LMS. It includes one or more unnormalized tables containing redundancy, anomalies, and repeating groups.

### Step 2: Normalize to 3NF
For each table in the file:

1. **Analyze the Unnormalized Table**  
   - Identify any repeating groups or embedded multivalued data.

2. **Convert to 1NF**  
   - Eliminate repeating groups.
   - Ensure each field contains only atomic (indivisible) values.

3. **Convert to 2NF**  
   - Remove partial dependencies (i.e., non-key attributes dependent only on part of a composite primary key).
   - Make sure every non-key attribute is fully functionally dependent on the entire primary key.

4. **Convert to 3NF**  
   - Eliminate transitive dependencies (i.e., non-key attributes depending on other non-key attributes).
   - Ensure all attributes are only dependent on the primary key.

### Step 3: Document Your Work
For each stage of normalization:
- Include the table layout after that stage (you may type it in a table or draw and paste an image).
- Write a short explanation of the changes made and why they were necessary.

---

## Submission Requirements

- **Format:** Submit your assignment as a single, clearly organized PDF document.
- **Structure:** Use headings for each table and subheadings for each normalization stage (1NF, 2NF, 3NF).
- **Length:** Approx. 3–5 pages depending on the complexity of the tables.

### Example Structure:

**Table A: Course Enrollment**
- **Unnormalized Table:** *(Insert table)*
- **1NF:** *(Insert table + explanation)*
- **2NF:** *(Insert table + explanation)*
- **3NF:** *(Insert table + explanation)*

---

## Grading Criteria

- **Correctness of Normalization (60%)**: Accurate transformation into 1NF, 2NF, and 3NF.
- **Explanations (25%)**: Clear and thoughtful reasoning for each transformation.
- **Clarity and Presentation (15%)**: Document is organized, well-formatted, and easy to follow.

---

## Due Date

Submit your completed PDF file via the course LMS by **[Insert Due Date Here]**.

---

This assignment will help you internalize the normalization process and build your skills in identifying and resolving database design issues. Good luck!

