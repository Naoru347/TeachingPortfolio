# Live Demo Guide

*Milestone 3 – Final Integration & Application*  
*Demo Duration: ~5–6 minutes*  
*File: `milestone3/docs/presentation/demo_guide.md`*

---

## 1. Demo Objectives
- **Showcase Core Functionality:** Demonstrate 2–3 key features of your application.  
- **Illustrate DS/Algorithm Integration:** Highlight how your data-structures library powers those features.  
- **Verify Robustness:** Show handling of edge cases or error conditions.  
- **Engage All Team Members:** Ensure each member participates by running a specific demo segment.

---

## 2. Preparation & Setup
1. **Environment Check:** Verify the application builds and runs on the demo machine:  
   ```bash
   cd milestone3/src
   javac -d ../../bin edu/gwu/csc220/app/Main.java
   java -cp ../../bin edu.gwu.csc220.app.Main
   ```  
2. **Sample Data:** Place any input files under `milestone3/data/` and reference them in commands or UI.  
3. **Demo Script:** Follow `docs/presentation/demo_script.md` for exact commands, parameters, and expected output.  
4. **Backup Commands:** Keep one-liner commands ready in case of UI hiccups (e.g., run a headless test mode).

---

## 3. Demo Flow & Roles
| Segment                        | Action                                                      | Presenter       | Duration |
|--------------------------------|-------------------------------------------------------------|-----------------|----------|
| **Intro & Launch**             | Open terminal/IDE, build and start the application          | Team Member A   | 30s      |
| **Feature 1**                  | Execute core functionality #1 (e.g., enqueue & schedule)    | Team Member B   | 1m       |
| **Feature 2**                  | Showcase feature #2 (e.g., file-system operations)          | Team Member C   | 1m       |
| **Edge-Case Handling**         | Demonstrate error handling (invalid input or empty state)   | Team Member A   | 1m       |
| **Performance Mode**           | Run a quick profiling or timing demo (e.g., large n test)    | Team Member B   | 1m       |
| **Summary & Handoff to Q&A**   | Brief recap of demo and prepare for audience questions      | Team Member C   | 30s      |

> **Tip:** Practice transitions so each handoff is seamless. Use clear verbal cues (e.g., “Now I’ll show…”).

---

## 4. Tips for a Smooth Demo
- **Preload Data:** Keep sample datasets preloaded to avoid delays.  
- **Minimal Setup:** Automate environment startup in a script (e.g., `run_demo.sh`).  
- **Fail-Safe Mode:** Prepare fallback commands in case of errors (e.g., hard-coded test).  
- **Time Awareness:** Assign a timekeeper to signal when you’re nearing your time limit.  
- **Clear Narration:** Explain what you’re doing and why; reference slide visuals as needed.

---

## 5. Contingency Planning
- **Network/Hardware Issues:** Have screenshots or screen recordings of demo steps.  
- **Code Errors:** Pre-commit a stable demo branch tagged `demo-ready` that you can revert to.  
- **No Internet:** Ensure all resources are local; no external API calls.

---

**Use this guide alongside your slide deck and demo script to deliver a confident, engaging live demo that highlights your application’s strengths.**

