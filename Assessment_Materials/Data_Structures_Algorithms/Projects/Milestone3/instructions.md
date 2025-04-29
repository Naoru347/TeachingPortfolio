# Milestone 3: Final Integration & Application Instructions

**Due:** Final Exam Week (Week 16, Friday 11:59 PM)  
**Weight:** 10 %  
**Folder:** `milestone3/`

---

## 1. Overview
In this final milestone, your team will integrate all previously implemented data structures and algorithms into a cohesive application. You will demonstrate end-to-end functionality, evaluate runtime performance, document design decisions, and present your work to the class.

**Key Objectives:**
1. Build an application leveraging your DS/algorithm library under `src/`  
2. Analyze and optimize performance  
3. Communicate architecture and insights through a written report and live demo

---

## 2. Integrated Application
### 2.1 Application Examples
Choose one real-world-inspired project (or propose your own):
- **Task Scheduler:** Prioritize and schedule tasks using priority queues
- **File-System Simulator:** Manage directories and file metadata with trees and hash tables
- **Graph-Based Planner:** Model routes or dependencies using graphs and shortest-path algorithms

### 2.2 Folder Structure
```
milestone3/
├── src/                    # Your integrated application code
│   └── edu/gwu/csc220/app/
│       └── Main.java       # Entry point
├── lib/                    # DS & algorithm library (from milestone1 & 2)
│   └── edu/gwu/csc220/ds/
├── data/                   # Sample input datasets (optional)
└── docs/
    ├── final_report.md     # 5–7 page report
    └── presentation/       # Slides & assets
        ├── slides.pdf
        └── demo_script.md
```

### 2.3 Functionality Requirements
- Integrate at least **three** distinct ADTs (e.g., BST, Heap, HashTable, Graph)  
- Support valid inputs and handle edge cases gracefully  
- Include logging or console output to illustrate runtime behavior

---

## 3. Final Report (5–7 pages)
### 3.1 Content Sections
1. **Architecture Overview:** Describe main components and module interactions; include a high-level UML or sequence diagram.  
2. **Performance Profiling:** Show profiling methodology, metrics collected (e.g., time, memory), and before/after optimization comparisons.  
3. **Design Trade-offs & Optimizations:** Discuss key decisions, alternative approaches considered, and impact of optimizations.  
4. **Lessons Learned:** Reflect on team collaboration, challenges, and future improvements.

### 3.2 Formatting
- Use Markdown or PDF under `docs/final_report.md`  
- Include tables, charts, and code snippets as needed  
- Cite any external libraries or resources

---

## 4. Presentation & Demo (10 minutes + Q&A)
### 4.1 Slide Deck
- **Length:** 8–10 slides  
- **Content:** Brief intro, architecture diagram, key features, performance results, reflection  
- **Format:** PDF or PowerPoint in `docs/presentation/slides.pdf`

### 4.2 Live Demo
- **Duration:** 5–6 minutes to showcase core functionality  
- **Script:** Provide `docs/presentation/demo_script.md` outlining steps and expected outputs

### Special Instrcutions  
- **Group Participation:** Each team member must speak and present at least one part of the demo or presentation, and participate in the Q&A session  
- **Q&A:** Be prepared to answer technical questions on design and performance

---

## 5. Deliverables Checklist
Submit the following in `milestone3/`:
- [ ] **Application Code:** `milestone3/src/` fully integrated and runnable via `Main.java`
- [ ] **Library Code:** `milestone3/lib/` containing DS implementations from Milestones 1 & 2
- [ ] **Final Report:** `milestone3/docs/final_report.md` (5–7 pages)
- [ ] **Presentation Slides:** `milestone3/docs/presentation/slides.pdf`
- [ ] **Demo Script:** `milestone3/docs/presentation/demo_script.md`
- [ ] **Tags/Releases:** Git tags `milestone1`, `milestone2`, `milestone3` present
- [ ] **Peer Evaluation Summary:** Confirm submission if required

---

## 6. Submission Instructions
1. Create branch `milestone3`  
2. Commit and push all deliverables  
3. Open a pull request titled “Milestone 3: Final Integration & Application”  
4. Tag the merge commit with `milestone3`  
5. Ensure project builds and runs without errors

**Congratulations—this is your capstone! Showcase your best work and celebrate the skills you’ve built.**

