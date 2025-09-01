# Frequently Asked Questions (FAQ)
## CSC 220: Data Structures & Algorithms - Semester Project

---

## General Project Questions

### Q: How are teams formed?
**A:** Teams are formed during Week 1. You can self-select teams of 3-4 students, or the instructor will assign teams based on complementary skills and schedules. Team formation is finalized by end of Week 2.

### Q: Can team membership change during the semester?
**A:** Team changes are discouraged but possible in exceptional circumstances (student withdrawal, major conflicts). Any changes must be approved by the instructor and require documentation of the situation.

### Q: What communication tools should we use?
**A:** **Recommended tools:**
- **Primary:** Course Discord server for real-time communication
- **Code coordination:** GitHub Issues for task tracking and bug reports
- **Document sharing:** Google Docs for collaborative writing (export to PDF for submission)
- **Meetings:** Zoom, Teams, or in-person for team meetings
- **File sharing:** GitHub for code, Google Drive for large documents
- **Avoid:** Email chains for team coordination (use for instructor communication only)

### Q: How do we handle disagreements about code or design?
**A:** **Conflict resolution process:**
1. **Discussion:** Give everyone a chance to present their viewpoint
2. **Role authority:** Relevant role leader makes the decision (Design Lead for architecture, etc.)
3. **Compromise:** Look for solutions that address multiple concerns
4. **Documentation:** Record the decision and rationale
5. **Instructor consultation:** Seek guidance if team cannot reach agreement
6. **Move forward:** Don't let perfect be the enemy of good

### Q: What if someone misses important team meetings?
**A:** **Meeting accountability:**
- **Advance notice:** Require 24-hour notice for absence when possible
- **Meeting notes:** Keep detailed records of all decisions made
- **Catch-up responsibility:** Absent members must review notes and ask questions
- **Critical decisions:** Postpone major decisions if key team member absent
- **Pattern of absence:** Document repeated absences for peer evaluations

### Q: How do we coordinate work when team members have different schedules?
**A:** **Schedule coordination strategies:**
- **Shared calendar:** Use Google Calendar or similar to track availability
- **Core hours:** Establish minimum overlap hours when everyone is available
- **Asynchronous work:** Design tasks that can be completed independently
- **Flexible meetings:** Rotate meeting times to accommodate different schedules
- **Documentation:** Thorough documentation reduces need for synchronous coordination

### Q: What should we do if communication breaks down?
**A:** **Communication recovery steps:**
1. **Acknowledge the problem:** Don't ignore communication issues
2. **Team discussion:** Hold a dedicated meeting to address communication problems
3. **Establish protocols:** Create clear communication expectations and guidelines
4. **Use structured communication:** Try daily standups or weekly check-in templates
5. **Seek mediation:** Contact instructor if team cannot resolve communication issues
6. **Individual responsibility:** Each member must commit to improved communication

### Q: How do we handle different work styles and preferences?
**A:** **Managing diverse work styles:**
- **Early discussion:** Talk about work preferences and styles during team formation
- **Role matching:** Assign roles that align with individual strengths and preferences
- **Flexibility:** Allow some variation in how individuals complete their work
- **Clear expectations:** Establish minimum standards that everyone must meet
- **Regular check-ins:** Ensure different work styles aren't causing conflicts
- **Focus on outcomes:** Judge by results rather than specific work methods

### Q: What if team members have different skill levels?
**A:** **Managing skill diversity:**
- **Skill assessment:** Honest discussion of everyone's strengths and areas for improvement
- **Mentoring:** Pair stronger students with those who need more support
- **Task allocation:** Assign tasks based on current skill level and learning goals
- **Knowledge sharing:** Regular code reviews and explanation sessions
- **Equal contribution:** Ensure everyone has meaningful work despite skill differences
- **Growth mindset:** Focus on learning and improvement rather than current ability

### Q: How should we handle team members who aren't contributing equally?
**A:** **Addressing unequal contribution:**
1. **Early intervention:** Address issues as soon as they become apparent
2. **Direct communication:** Talk to the person privately first
3. **Clear expectations:** Reiterate specific responsibilities and deadlines
4. **Support offer:** Ask if they need help or are facing obstacles
5. **Team discussion:** If individual conversation doesn't help, involve whole team
6. **Documentation:** Keep records of contribution issues for peer evaluations
7. **Instructor involvement:** Contact instructor if problem persists or affects milestone success

---

## Grading and Assessment Questions

### Q: How are individual grades determined within teams?
**A:** **Multi-factor individual assessment:**
- **Base team grade:** Applied to all team members initially
- **Peer evaluation adjustment:** +/- based on peer feedback (5% of milestone grade)
- **Individual contribution:** Assessed through commit history, documentation, peer feedback
- **Role performance:** How well each person fulfilled their rotating role
- **Participation:** Engagement in team meetings and decision-making

### Q: What happens if our team performs poorly on a milestone?
**A:** **Recovery strategies:**
- **Feedback incorporation:** Use instructor feedback to improve next milestone
- **Role reassignment:** Consider whether different role assignments might help
- **Extra support:** Increase office hours attendance and TA consultation
- **Process improvement:** Analyze what went wrong and adjust team processes
- **Individual accountability:** Ensure everyone understands their responsibilities

### Q: Can we get partial credit for incomplete features?
**A:** **Partial credit policy:**
- **Documented attempts:** Partial credit for well-documented incomplete features
- **Testing:** Tests for incomplete features can still earn testing points
- **Design credit:** Good design documentation earns credit even if implementation incomplete
- **No credit:** No partial credit for missing or non-functional code without documentation
- **Late completion:** Better to submit complete work late than incomplete work on time

### Q: How are presentation grades assigned?
**A:** **Presentation assessment:**
- **Team grade:** Overall presentation quality, demo effectiveness, timing
- **Individual contribution:** Each member must present part of the project
- **Q&A handling:** Individual responses to questions about your role/contributions
- **Preparation:** Evidence of rehearsal and coordination
- **Technical demos:** Live demonstration of working features (have backup plan!)

---

## Advanced Technical Questions

### Q: How do we implement thread-safe data structures?
**A:** **Thread safety is optional but encouraged:**
- **Java:** Use synchronized methods or locks appropriately
- **Python:** Use threading.Lock or queue.Queue for thread-safe operations
- **Testing:** Create multi-threaded test cases if you implement thread safety
- **Documentation:** Clearly document thread safety guarantees
- **Performance impact:** Analyze performance cost of synchronization

### Q: Should we implement iterators for our data structures?
**A:** **Iterators are encouraged for Milestone 2+:**
- **Java:** Implement Iterator<T> interface
- **Python:** Implement __iter__ and __next__ methods
- **Functionality:** Support for-each loops and enhanced iteration
- **Fail-fast:** Consider concurrent modification detection
- **Testing:** Test iterator behavior thoroughly

### Q: How do we handle very large datasets in our performance analysis?
**A:** **Scalable testing approach:**
- **Memory constraints:** Test within available system memory
- **Time limits:** Set reasonable time limits for test execution
- **Sampling:** Use representative samples of larger datasets
- **Profiling:** Focus on algorithmic behavior, not absolute performance
- **Documentation:** Note hardware limitations in performance analysis

### Q: Can we implement additional data structures beyond requirements?
**A:** **Extra implementations are encouraged:**
- **Bonus consideration:** May earn bonus points for exceptional work
- **Integration:** Must meaningfully integrate with required structures
- **Quality standards:** Same documentation and testing standards apply
- **Time management:** Don't sacrifice required features for optional ones
- **Examples:** Red-black trees, tries, skip lists, bloom filters

---

## Troubleshooting Common Issues

### Development Environment Issues

### Issue: "Java/Python version conflicts between team members"
**Solutions:**
- **Standardize versions:** Agree on specific versions (Java 11+, Python 3.8+)
- **Documentation:** Document required versions in README
- **Version managers:** Use SDKMAN (Java) or pyenv (Python) for version management
- **Build files:** Specify versions in build.gradle or setup.py
- **CI/CD:** Set up automated builds to catch version issues early

### Issue: "IDE differences causing code formatting conflicts"
**Solutions:**
- **Style guides:** Agree on code formatting standards (Google Style, PEP 8)
- **Formatter configs:** Share IDE formatter configuration files
- **Pre-commit hooks:** Use tools like pre-commit to enforce formatting
- **Manual formatting:** Establish team formatting conventions
- **Focus on functionality:** Don't let formatting disputes derail progress

### Git and Version Control Issues

### Issue: "Accidentally committed large files or sensitive data"
**Solutions:**
- **Git history cleanup:** Use `git filter-branch` or BFG Repo-Cleaner carefully
- **Sensitive data:** Change any exposed passwords/keys immediately
- **Prevention:** Properly configure .gitignore from project start
- **Repository restart:** Create new repository if cleanup is too complex
- **Learn from mistakes:** Establish better practices going forward

### Issue: "Branch strategy is confusing and causing conflicts"
**Solutions:**
- **Simplify strategy:** Use simple main + milestone-dev branches
- **Clear responsibilities:** Designate one person to manage merges
- **Communication:** Announce before making major merges
- **Backup branches:** Create backup branches before risky operations
- **Training:** Ensure all team members understand Git workflow

### Testing and Quality Issues

### Issue: "Tests pass locally but fail in other environments"
**Solutions:**
- **Environment documentation:** Document exact test environment requirements
- **Test data paths:** Use relative paths for test data files
- **Resource management:** Properly close files and resources in tests
- **Test isolation:** Ensure tests don't depend on each other
- **CI environment:** Test in clean environment (GitHub Actions, etc.)

### Issue: "Performance tests give inconsistent results"
**Solutions:**
- **Controlled environment:** Close unnecessary applications during testing
- **Multiple iterations:** Run tests multiple times and average results
- **Statistical analysis:** Report confidence intervals and standard deviations
- **Benchmark isolation:** Run performance tests separately from unit tests
- **Hardware documentation:** Document test hardware specifications

### Documentation and Communication Issues

### Issue: "Team members have different writing styles in documents"
**Solutions:**
- **Style guide:** Establish team writing style guidelines
- **Single editor:** Designate one person to do final editing pass
- **Template usage:** Use provided document templates consistently
- **Review process:** Have multiple people review all documents
- **Version control:** Use Git for document version control when possible

### Issue: "Presentation coordination is chaotic"
**Solutions:**
- **Script preparation:** Write out who says what during presentation
- **Rehearsal:** Practice presentation multiple times before deadline
- **Backup plans:** Have backups for technical demos
- **Time management:** Assign specific time limits to each presenter
- **Q&A preparation:** Prepare for likely questions in advance

---

## Resources and Support

### Documentation Resources
- **Course materials:** All templates and examples in course repository
- **Writing guides:** APA/IEEE formatting guides provided
- **UML tools:** draw.io, Lucidchart, PlantUML for diagram creation
- **Code documentation:** JavaDoc and Python docstring standards
- **Markdown guide:** GitHub Markdown documentation for README files

### Technical Resources
- **Java documentation:** Oracle Java documentation and tutorials
- **Python documentation:** Official Python documentation and PEP guides
- **Algorithm references:** Course textbook, Algorithms 4th Edition (Sedgewick)
- **Data structure visualizations:** VisuAlgo, Algorithm Visualizer
- **Performance analysis:** Big-O Cheat Sheet, complexity analysis guides

### Development Tools
- **IDEs:** IntelliJ IDEA, Eclipse, PyCharm, VS Code
- **Build tools:** Maven, Gradle (Java); pip, setuptools (Python)
- **Testing frameworks:** JUnit, TestNG (Java); pytest, unittest (Python)
- **Version control:** Git, GitHub Desktop, command line Git
- **Profiling tools:** JProfiler, VisualVM (Java); cProfile, py-spy (Python)

### Getting Additional Help

### Academic Support
- **Office hours:** Tuesday/Thursday 1:00-3:00 PM (Dr. Paiz)
- **TA support:** Monday/Wednesday 4:00-6:00 PM in lab
- **Tutoring center:** STEM Learning Center for general programming help
- **Study groups:** Form study groups with other teams (no code sharing)

### Technical Support
- **Course Discord:** #technical-help channel for quick questions
- **Stack Overflow:** For general programming questions (cite sources)
- **GitHub documentation:** For repository and Git issues
- **University IT:** For campus network and system issues

### Personal Support
- **Academic advising:** For course planning and academic concerns  
- **Counseling services:** For stress management and personal issues
- **Dean of students:** For emergency situations affecting academic performance
- **Disability services:** For accommodation requests

### Emergency Contacts
- **Instructor email:** jpaiz@gwu.edu (respond within 24 hours)
- **TA email:** [TA contact information provided separately]
- **Course Discord:** #general channel for urgent course-related issues
- **Department office:** For serious academic concerns

---

## Final Reminders

### Success Strategies
1. **Start early:** Begin work immediately after each milestone is assigned
2. **Communicate regularly:** Daily check-ins prevent major surprises
3. **Test continuously:** Don't leave testing until the end
4. **Document as you go:** Don't save all documentation for the end
5. **Ask for help:** Use office hours and TA support proactively
6. **Learn from mistakes:** Each milestone builds on lessons from previous ones

### Professional Development
This project simulates real-world software development:
- **Version control:** Essential skill for any programming job
- **Team collaboration:** Critical for professional software development
- **Documentation:** Required for maintainable software systems
- **Testing:** Quality assurance is fundamental to professional development
- **Performance analysis:** Understanding algorithmic efficiency is crucial

### Academic Integrity Reminder
- **Original work:** All implementations must be your own team's work
- **Collaboration limits:** Teams can discuss concepts but not share code
- **Citation required:** Cite any external resources used for learning
- **AI policy:** Follow course AI policy strictly (documentation required)
- **Honor code:** Uphold academic integrity throughout the project

---

## Still Have Questions?

### Before Asking for Help
1. **Check this FAQ:** Many common questions are answered here
2. **Review course materials:** Check syllabus, rubrics, and assignment descriptions
3. **Search Discord:** See if someone else has asked the same question
4. **Try debugging:** Attempt to solve technical issues independently first
5. **Consult team:** Get input from teammates on design/process questions

### How to Ask Effective Questions
1. **Be specific:** "Our AVL rotation isn't working" vs "Our code is broken"
2. **Show your work:** Explain what you've tried so far
3. **Provide context:** Include relevant code, error messages, or examples
4. **Ask at the right level:** Technical details to TAs, policy questions to instructor
5. **Follow up:** Let us know if our suggestions worked

### Contact Methods
- **Quick questions:** Course Discord #general or #technical-help
- **Detailed technical help:** Office hours or lab sessions
- **Policy questions:** Email instructor directly
- **Team conflicts:** Private email or individual office hours meeting
- **Emergency situations:** Email instructor with "URGENT" in subject line

Remember: This project is designed to challenge you while providing support for success. Don't hesitate to use the resources available to you! happens if a team member stops participating?
**A:** 
1. **First:** Try to resolve issues through team communication
2. **Second:** Document the situation and contact the instructor
3. **Third:** Individual grade adjustments may be made based on peer evaluations
4. **Last resort:** Team restructuring with instructor approval

### Q: How much time should we expect to spend on the project?
**A:** Plan for 8-12 hours per week per person across all three milestones. Time investment varies by milestone:
- **Milestone 1:** ~30 hours total per person (6 weeks)
- **Milestone 2:** ~25 hours total per person (5 weeks)  
- **Milestone 3:** ~20 hours total per person (5 weeks)

---

## Technical Implementation Questions

### Q: Which programming language should we use?
**A:** You can choose **Java** or **Python**. Consider your team's experience, but Java is recommended for stronger type safety and performance analysis. All team members must use the same language.

### Q: Can we use external libraries or frameworks?
**A:** **Limited use allowed:**
- **Testing frameworks:** JUnit, TestNG, pytest, unittest (encouraged)
- **Build tools:** Maven, Gradle, setuptools (required)
- **Benchmarking:** Built-in timing libraries only
- **Data structures:** You must implement core structures yourself
- **Utilities:** Basic I/O, string manipulation, math libraries are fine

**Prohibited:**
- Pre-built data structure libraries (Collections, STL, etc.) for your implementations
- Third-party algorithm implementations  
- AI code generation tools (see course AI policy)

### Q: How do we handle generic types and type safety?
**A:** 
- **Java:** Use proper generic syntax (`<T extends Comparable<T>>`)
- **Python:** Use type hints (`from typing import Generic, TypeVar`)
- All data structures must support generic types
- Include type safety in your testing strategy

### Q: What level of error handling is expected?
**A:** **Professional-level error handling:**
- **Null pointer protection:** Check for null inputs
- **Bounds checking:** Validate array/list indices  
- **State validation:** Ensure data structure invariants
- **Custom exceptions:** Create meaningful exception classes
- **Documentation:** Document all exceptions in JavaDoc/docstrings

### Q: How detailed should our algorithms be?
**A:** Implement algorithms **from scratch** using fundamental operations:
- No calling built-in sort functions for your sorting algorithms
- Implement tree rotations step-by-step for AVL trees
- Show understanding of algorithmic complexity through implementation choices
- Comment complex algorithmic logic clearly

---

## Milestone-Specific Questions

### Milestone 1 Questions

### Q: What's the difference between the different linked list types?
**A:**
- **Singly Linked:** Each node points to next node only
- **Doubly Linked:** Each node has pointers to both next and previous nodes  
- **Circular Linked:** Last node points back to first node (can be singly or doubly linked)
- Implement separate classes for each type with appropriate operations

### Q: Should our Stack and Queue share code with our linked lists?
**A:** **Good design practice:** Your Stack and Queue can **use** your linked list implementations internally (composition), but they should present different interfaces. Don't inherit from LinkedList.

### Q: How comprehensive should our unit tests be?
**A:** **Minimum 80% coverage required:**
- Test normal operations (insert, delete, search)
- Test boundary conditions (empty structures, single elements)
- Test error conditions (invalid indices, null inputs)
- Test performance with various data sizes
- Include integration tests between related structures

### Milestone 2 Questions

### Q: How complex should our AVL tree rotations be?
**A:** **Implement all four rotation types:**
- Left rotation (single)
- Right rotation (single)
- Left-Right rotation (double)
- Right-Left rotation (double)
- Maintain balance factors correctly
- Test with sequences that trigger each rotation type

### Q: What collision resolution strategies should we implement for hash tables?
**A:** **Minimum two strategies required:**
- **Linear Probing:** Check next available slot sequentially
- **Separate Chaining:** Use linked lists at each bucket
- **Optional:** Quadratic probing, double hashing
- Support runtime selection of strategy
- Compare performance between strategies in benchmarks

### Q: How accurate should our performance benchmarks be?
**A:** **Use statistical rigor:**
- Run multiple trials (minimum 5 iterations)
- Report average times with standard deviations
- Test with varying data sizes (1K, 10K, 100K elements)
- Account for JVM warmup (Java) or interpreter overhead (Python)
- Compare results to theoretical complexity predictions

### Milestone 3 Questions

### Q: What kind of application should we build?
**A:** **Choose applications that meaningfully use your data structures:**
- **Task Scheduler:** Priority queues, hash tables for fast lookup
- **File System Simulator:** Trees for directory structure, lists for file operations
- **Graph Planner:** Hash tables for vertices, lists for adjacency representation
- **Social Network Analyzer:** Multiple structures for different relationship types
- Must demonstrate performance benefits of your chosen structures

### Q: How should we approach performance optimization?
**A:** **Systematic optimization approach:**
1. **Profile first:** Identify actual bottlenecks, don't guess
2. **Measure baseline:** Record performance before optimization
3. **Optimize iteratively:** One change at a time
4. **Verify improvements:** Measure performance after each change
5. **Document trade-offs:** Explain what you sacrificed for performance gains

### Q: What should our final presentation cover?
**A:** **10-minute presentation structure:**
- **2 minutes:** Project overview and team roles
- **3 minutes:** Live demo of integrated application
- **3 minutes:** Performance analysis and optimization results
- **2 minutes:** Lessons learned and future improvements
- Practice timing and prepare for Q&A session

---

## Testing and Quality Questions

### Q: What testing frameworks should we use?
**A:**
- **Java:** JUnit 4 or 5, with Hamcrest for assertions
- **Python:** pytest or unittest, with pytest-cov for coverage
- **Coverage tools:** JaCoCo (Java) or coverage.py (Python)
- Set up automated testing in your build process

### Q: How do we test performance and complexity?
**A:** **Multi-layered testing approach:**
- **Unit tests:** Test correctness of individual operations
- **Performance tests:** Time operations with various input sizes
- **Complexity verification:** Verify O(log n) operations actually scale logarithmically
- **Stress tests:** Test with large datasets and edge cases
- **Regression tests:** Ensure optimizations don't break functionality

### Q: What code quality standards should we follow?
**A:** **Professional code standards:**
- **Naming:** Descriptive variable and method names
- **Comments:** JavaDoc/docstrings for all public methods
- **Formatting:** Consistent indentation and style
- **DRY principle:** Don't Repeat Yourself - factor out common code
- **SOLID principles:** Single responsibility, interface segregation
- Use linting tools (CheckStyle, pylint) if available

### Q: How do we handle testing randomized algorithms or data?
**A:** **Deterministic testing strategies:**
- Use fixed seeds for random number generators
- Test with known input/output pairs
- Test statistical properties (e.g., hash distribution)
- Include both randomized and deterministic test cases
- Document random test procedures in your test documentation

---

## Documentation and Submission Questions

### Q: What format should our design documents be in?
**A:** **Professional PDF documents:**
- Use proper headings and section organization
- Include UML diagrams created with professional tools (draw.io, Lucidchart)
- Embed charts and graphs directly in documents
- Follow academic writing standards (see writing guide)
- Export presentations as PDF for archival

### Q: How detailed should our complexity analysis be?
**A:** **Rigorous mathematical analysis:**
- Provide Big-O, Big-Θ, and Big-Ω analysis where appropriate
- Show work for recurrence relation solutions
- Compare theoretical predictions with empirical measurements
- Explain discrepancies between theory and practice
- Include space complexity analysis, not just time

### Q: What should we do if our repository gets too large?
**A:** **Repository size management:**
- Use `.gitignore` to exclude build artifacts, IDE files
- Don't commit large data files or binary results
- Use Git LFS for large files if absolutely necessary
- Keep benchmark result files small (CSV format, not raw data)
- Clean up temporary files regularly

### Q: Can we use AI tools for documentation or code generation?
**A:** **Limited AI assistance allowed for:**
- **Grammar/style checking:** Grammarly, spell checkers
- **Formatting help:** Markdown formatting, LaTeX assistance  
- **Research:** Finding documentation, tutorials, examples

**Prohibited AI usage:**
- **Code generation:** ChatGPT, Copilot for implementation
- **Algorithm design:** AI-suggested algorithms or optimizations
- **Problem-solving:** AI solutions to specific project requirements
- **Documentation writing:** AI-generated technical content
- Any AI usage must be documented and approved

---

## Common Problems and Solutions

### Problem: "Our code works on one person's machine but not others"
**Solutions:**
- **Environment standardization:** Document exact versions of tools/dependencies
- **Relative paths:** Use relative paths, never absolute paths
- **Build scripts:** Create scripts that set up the environment
- **Container usage:** Consider Docker for environment consistency
- **Test on multiple platforms:** Regularly test on different operating systems

### Problem: "We can't agree on design decisions"
**Solutions:**
- **Role authority:** Design Lead has final say on architectural decisions
- **Decision documentation:** Write down the rationale for decisions
- **Prototyping:** Build small prototypes to test different approaches
- **Instructor consultation:** Ask for guidance during office hours
- **Compromise:** Find solutions that address everyone's concerns

### Problem: "Our performance benchmarks are inconsistent"
**Solutions:**
- **Multiple runs:** Average results over many iterations
- **Controlled environment:** Close other applications during benchmarking
- **Warmup period:** Run operations before measuring to warm up the system
- **Statistical analysis:** Report standard deviations and confidence intervals
- **Consistent methodology:** Use the same measurement approach for all tests

### Problem: "We're running out of time before the deadline"
**Solutions:**
- **Prioritize requirements:** Focus on required features first
- **Parallel work:** Divide tasks among team members more effectively
- **Minimum viable product:** Get basic functionality working, then add features
- **Documentation triage:** Ensure core documentation is complete first
- **Seek help early:** Don't wait until the last minute to ask for assistance

### Problem: "Our tests are failing mysteriously"
**Solutions:**
- **Debugging strategy:** Use debugger to step through failing tests
- **Isolation testing:** Test components individually before integration
- **Print debugging:** Add logging statements to understand program flow
- **Test data validation:** Ensure test data is what you expect it to be
- **Assumption checking:** Verify all assumptions about how code should behave

### Problem: "Git merge conflicts are breaking our code"
**Solutions:**
- **Frequent communication:** Coordinate who's working on what files
- **Small, frequent commits:** Commit changes regularly to avoid large conflicts
- **Branch strategy:** Use feature branches for major changes
- **Conflict resolution skills:** Learn proper merge conflict resolution techniques
- **Backup strategy:** Keep local backups before attempting complex merges

---

## Performance and Optimization Tips

### General Performance Tips
- **Profile before optimizing:** Don't optimize without measuring
- **Focus on algorithmic complexity:** O(n²) to O(n log n) matters more than micro-optimizations
- **Memory locality:** Consider cache-friendly data access patterns
- **Avoid premature optimization:** Get correctness first, then optimize
- **Measure everything:** Quantify the impact of every optimization

### Language-Specific Tips

#### Java Performance
- **StringBuilder:** Use for string concatenation in loops
- **ArrayList sizing:** Pre-size collections when you know capacity
- **Boxing overhead:** Be aware of autoboxing costs with generics
- **JVM warmup:** Account for JIT compilation in benchmarks
- **Memory management:** Understand garbage collection impact

#### Python Performance  
- **List comprehensions:** Often faster than explicit loops
- **Built-in functions:** Use built-in functions when they don't violate requirements
- **String operations:** Be aware that strings are immutable
- **Integer operations:** Large integer operations can be slow
- **Profiling tools:** Use cProfile for detailed performance analysis

### Data Structure Specific Tips
- **Hash tables:** Good hash functions are crucial for performance
- **Trees:** Keep trees balanced for optimal search performance
- **Arrays vs. Linked Lists:** Understand memory access patterns
- **Cache considerations:** Sequential access is often faster than random access
