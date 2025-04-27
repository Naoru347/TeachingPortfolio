# Homework: Database Disaster Recovery Scenario

## Overview
In this homework, you will be presented with a fictional database failure scenario. Your task is to step into the role of a database administrator and outline the steps you would take to restore the database and recover lost or corrupted data. By working through this scenario, you'll strengthen your understanding of backup and recovery procedures, as well as best practices for maintaining data integrity.

---

## Disaster Scenario
**Fictional Event**:  
The **CampusEventDB** database, used to manage events and registrations at your community college, has just suffered a major data corruption incident due to a power surge and unexpected server reboot. Several key tables, including **Events**, **Registrations**, and **Venues**, now contain corrupted entries and missing data. The last known good backup was taken **24 hours ago**, and new events were added to the system shortly before the crash.

---

## Homework Objectives
1. **Understand Backup & Recovery Processes**: Apply concepts of database backups, point-in-time recovery, and testing.
2. **Develop a Disaster Recovery Plan**: Clearly outline the logical steps to restore data, minimize data loss, and verify system integrity.
3. **Consider Preventive Measures**: Reflect on how to avoid similar disasters in the future through proactive strategies and best practices.

---

## Instructions

1. **Assess the Damage**  
   - Describe how you would determine which data is corrupted or missing.
   - Note the timestamp of the last good backup (24 hours ago) and any changes made after that backup.

2. **Outline Your Restoration Plan**  
   - Identify what type(s) of backups you have (full, incremental, transaction log, etc.).  
   - Explain how you will restore from your most recent usable backup.  
   - Include steps for point-in-time recovery if your system supports it, focusing on transactions that occurred after the last backup.

3. **Verify and Validate**  
   - Describe the process of verifying the restored data’s integrity (e.g., running integrity checks, verifying foreign keys, etc.).  
   - Explain how you would confirm that the **Events**, **Registrations**, and **Venues** tables are back to normal working order and that no further corruption exists.

4. **Minimize Data Loss**  
   - If transactions happened between the last backup and the crash, propose how you might reapply or salvage data from partial logs or user records (if available).
   - Consider the trade-offs between an immediate system restore and a more thorough investigation to recover new data.

5. **Preventive Measures**  
   - Reflect on strategies to prevent similar incidents in the future (e.g., regular backups, replication, UPS systems, surge protectors, or better recovery point objectives).
   - Discuss the importance of testing backups and practicing recovery drills.

6. **Document Your Plan**  
   - Summarize your recommended steps in a clear, logical sequence.
   - Explain the rationale behind each step, demonstrating your understanding of backup and recovery best practices.

---

## Submission Requirements
- **Format**: Submit as a single PDF document.
- **Structure**:
  - **Introduction**: Briefly restate the disaster scenario.
  - **Steps & Rationale**: Use clear headings for each restoration step, with explanations.
  - **Preventive Measures**: Outline future safeguards.
  - **Conclusion**: Summarize your plan and any final thoughts on maintaining a reliable backup strategy.
- **Length**: Approximately 2–3 pages (not including screenshots, if any).

---

## Grading Criteria
1. **Completeness (40%)**: All steps (damage assessment, restoration plan, validation, preventive measures) are addressed thoroughly.
2. **Technical Accuracy (30%)**: Demonstrates understanding of backup types, recovery procedures, and potential data salvage methods.
3. **Organization & Clarity (20%)**: Logical structure, easy-to-follow explanation, and clear justification of steps.
4. **Professionalism (10%)**: Concise writing, minimal grammar/spelling errors, and a well-presented PDF submission.

---

## Due Date
Submit your final PDF document via the course LMS by **[Insert Due Date Here]**.

---

### Final Note
Real-world data disasters can happen unexpectedly—knowing how to respond effectively can save time, money, and critical data. Use this assignment to practice thinking like a database administrator in crisis mode, and have fun refining your disaster recovery plan!
