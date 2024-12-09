# General Teaching
Scaffolding is going to be massively important when teaching others to code. It'll be vitally important to ensure that the *proper* sequencing is maintained. For example, introducing global/local scope in one lesson and then returning to it in another to introduce variable shadowing and arbitrary arguments. 

Early on, it may be helpful to have students working with exisiting code snippets but tasking them with doing things like adding new features, debugging problems in the code, and writing test cases with the goal being to encourage more active learning. 

### Conceptualizing the Problem
- **Challenge**: Students may struggle to envision the larger picture, like how a library system operates or how the components of the program interact.
  - **Why It’s Hard**: Beginners often focus narrowly on individual parts of the program without grasping how they connect to solve the overall problem.
  - **Solution**: Use a real-world analogy (e.g., "Imagine managing a library manually with paper records") to establish the context. Then, map that to digital components: books as records, borrowing as updates, etc.

### Iterative Development
- **Challenge**: Students may feel overwhelmed when presented with the complete challenge and try to tackle everything at once.
  - **Why It’s Hard**: The multi-step nature of the program—handling input, manipulating data, and producing output—can feel daunting for beginners.
  - **Solution**: Teach iterative development by breaking the problem into smaller tasks. For instance:
    1. Start with adding books to the catalog.
    2. Introduce borrowing functionality.
    3. Add availability checks.

### Debugging and Testing
- **Challenge**: Debugging issues like typos in dictionary keys (`catalog[title]`) or input validation can confuse students.
  - **Why It’s Hard**: Error messages for incorrect key access or type mismatches may be difficult for students to interpret.
  - **Solution**: Encourage "debugging as a skill" by having students intentionally create common bugs (e.g., accessing a nonexistent key) and then guide them in resolving the errors.

# Teaching Python

## General Reflections
Specific to teaching Python is the question of when/how to address PEP standards with students. Is this something to address directly and througout the teaching? Or, is this best done implicitly instead so that students focus more on implementation?

## Coding-specific Reflections

### Problem Decomposition
- **Challenge**: Knowing how to break down a larger problem into smaller, solvable parts and knowing when you've reached the most atomic parts of a problem.
    - **Why It's Hard**: Students that are new to decomposition, or new to a specific domain, may not know how small is small enough. Others may be such higher-order thinkers that seeing the "leaves on the branches on the trees in the forest" is particularly challenging when they can't see past the forest to begin with.
    - **Solution**: Walk students through how programs use functions and these functions are a natural resault of the decomposition process. 

### Modular Thinking
- **Challenge**: Understanding why the program is organized into a function (`temperature_converter()`).
  - **Why It’s Hard**: Students new to programming may struggle to see why code reusability and organization matter.
  - **Solution**: Compare a script without functions to one with functions, highlighting the benefits of modular design.

### Code Reusability
- **Challenge**: Students often write repetative code instead of leveraging code reusability to minimize redundancy.
    - **Why It's Hard**: Students may be thinking through a problem too linearly/discretely instead of modularly. 
    - **Solution**: HAve students ID repetative code and work together to refactor it into usable functions (helper functions).

### Edge Cases
- **Challenge**: Anticipating and handling edge cases like missing units (e.g., `100`) or unsupported formats (e.g., `abcF`).
  - **Why It’s Hard**: Beginners often focus on the "happy path" and don’t think about invalid or unusual inputs.
  - **Solution**: Discuss the importance of testing and demonstrate how to handle unexpected inputs.

### Overall Conceptual Understanding
- **Challenge**: Understanding how the individual pieces (input, processing, output) work together in the program.
  - **Why It’s Hard**: Seeing the program as a cohesive whole requires practice in breaking down and assembling components.
  - **Solution**: Walk through the code step by step with example inputs, showing how data flows and transforms.


## Python-specific Reflections

### Pythonic Idioms
- **Challenge**: Students may write verbos or un-Pythonic code instead of leveraging Python's built-in features (e.g., list comprehension, unpacking, etc.)
    - **Why It's Hard**: Beginners often rely more simplistic approaches or lack familiarity with the intricacies of Python.
    - **Solution**: Introduce Pythonic alterinatives by rewriting common patterns (e.g., the generator expression)
    ```python
    total_salary = sum(emp["salary"] for emp in employees)

    # versus

    total_salary = 0
    for emp in employees:
        total_salary += emp["salary"]
    ```

### Package and Module Organization
- **Challenge**: Students often struggle to understand Python's package hierarchy and the import system. 
  - **Why It's Hard**: The concept of Python's module search path and package structure is often abstract and differes from simple script execution that beginners are familiar with.
  - **Solution**: Use physical analogies (like a library's organization catalog or GPS navigation) to explain how Python looks for modules. Create visual diagrams showing the relationship between packages, modules, and imports. 
 
### Import Conventions and Best Practices
- **Challenge**: Students may be confused about when to use different import styles
  - **Why It's Hard**: The flexibility of Python's import system can be overwhelming and students may not understand the implications of idfferent import approaches on code readability and namespace management.
  - **Solution**: Create clear guidelines for different import scenarios, using real-world examples to demonstrate each apporach and when they're appropriate. Show how imports affect code readability and maintenance. 

### Input Parsing and Validation
- **Challenge**: Understanding how to extract the numeric value and unit from a string like `100F`.
  - **Why It’s Hard**: It involves slicing strings, understanding string methods like `.strip()` and `.upper()`, and checking conditions.
  - **Solution**: Break down the input processing into clear, commented steps and explain each method’s purpose.

### Conditional Logic
- **Challenge**: Writing and organizing `if`/`elif`/`else` statements to handle valid and invalid units.
  - **Why It’s Hard**: Beginners often struggle with the flow of control or forget to handle edge cases like unsupported units.
  - **Solution**: Use a flowchart or pseudocode to demonstrate the decision-making process.

### String Manipulation
- **Challenge**: Using `temp_input[:-1]` to get the numeric part of the input and `temp_input[-1]` to get the unit.
  - **Why It’s Hard**: Beginners may not fully grasp Python’s string indexing and slicing.
  - **Solution**: Provide hands-on exercises focused on string slicing before introducing it in the program.

### *args and *kwargs
- **Challenge**: Python's support for arbitrary arguments can confuse beginners. 
    - **Why It's Hard**: Students may struggle to understand when and why to use these features, as well as how they differ from regular parameters. 
    - **Solution**: Use practice examples to explain these concepts. E.g., show how *args allow syou to pass multiple items of that type to a function, as in: 
    ```python
    def print_employees(*employees)
        for emp in employees: 
            print(f"- {emp['name']}, {emp['position']})
    ```

### Error Handling
- **Challenge**: Writing validation checks (e.g., ensuring input is numeric and the unit is valid).
  - **Why It’s Hard**: They may not know how to structure checks or use methods like `.isdigit()` and `.replace()`.
  - **Solution**: Explain why validation is important and give simpler examples of input validation (e.g., checking for integers first).

### Formatting Output
- **Challenge**: Using `f"{value:.1f}"` to format numbers to one decimal place.
  - **Why It’s Hard**: Students may not understand string interpolation or formatting syntax.
  - **Solution**: Provide examples of formatted strings and practice exercises to build familiarity.

  ### Dictionary Operations
- **Challenge**: Understanding how to manipulate nested dictionaries (e.g., `catalog[title]["copies"]`) or use methods like `.get()` to safely access values.
  - **Why It’s Hard**: Students may not fully understand the hierarchical structure of dictionaries or how to handle missing keys.
  - **Solution**: Provide visual representations of nested dictionaries and hands-on exercises to practice accessing and modifying values.

### String Manipulation and Validation

# Teaching Java
# Teaching Databases


