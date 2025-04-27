# Design Document Template

Use this template to guide your design write-up. Aim for a concise, 3–4 page document that clearly communicates your design decisions and analysis.

---

## 1. ADT Interface Definitions
Provide a clear contract for each data structure’s public interface. For each one, include:

- **ADT Name** (with generic type): e.g., `SinglyLinkedList<T>`
- **Description**: One or two sentences explaining the purpose, typical use cases, and important behaviors (e.g., ordering, mutability).
- **Public API**: Table or bullet list of methods including signature, parameters, return type, exception conditions, and a brief description.

Example:
```markdown
### SinglyLinkedList<T>
| Method                        | Signature                   | Description                                                                                   |
|-------------------------------|-----------------------------|-----------------------------------------------------------------------------------------------|
| `add`                         | `void add(T value)`         | Append `value` to end. Throws `IllegalArgumentException` if `value` is null.                  |
| `addAtIndex`                  | `void add(int index, T value)` | Insert `value` at `index`, shift subsequent elements. Throws `IndexOutOfBoundsException` if invalid. |
| `get`                         | `T get(int index)`          | Return element at `index` without removing. Throws `IndexOutOfBoundsException` if invalid.   |
| `remove`                      | `T remove(int index)`       | Remove and return element at `index`. Throws `IndexOutOfBoundsException` if invalid.          |
| `size`                        | `int size()`                | Return number of elements in constant time.                                                   |
```

> **Tip:** Consistent naming and clear exception documentation help users and graders understand your API.

---

## 2. Internal Representation Choices
Explain your implementation strategy in detail. For each ADT:

1. **Data Fields:** List key fields (e.g., `Node<T> head`, `Node<T> tail`, `int size`).
2. **Storage Format:** Describe data layout (linked nodes vs. backing array, head/tail pointers, sentinel nodes). Include a simple UML class diagram or ASCII art sketch.
3. **Memory Overhead:** Note any additional memory (e.g., node pointers, array resizing buffers).
4. **Rationale & Trade-offs:** Justify your choices: e.g., why a tail pointer for O(1) adds vs. simpler implementation; pros/cons of circular vs. sentinel-based lists.

> **Example Diagram:**  
> ```txt
> head -> [val|next] -> [val|next] -> null
> ```

---

## 3. Complexity Analysis
Summarize theoretical performance and relate to your implementation. Provide a table:

| Method            | Time Complexity | Space Complexity | Implementation Notes                                |
|-------------------|----------------:|-----------------:|-----------------------------------------------------|
| `add(value)`      | O(1)            | O(1)             | With `tail` pointer; otherwise O(n) without `tail`  |
| `remove(index)`   | O(n)            | O(1)             | Single pass traversal needed                        |
| `get(index)`      | O(n)            | O(1)             | Traversal from `head`                               |
| …                 |                 |                  |                                                     |

Include any assumptions (e.g., amortized O(1) for array-backed stacks when resizing is limited).

> **Tip:** Hand-draw or generate a quick benchmark graph to sanity-check your theoretical conclusions.

---

## 4. Design Trade-offs & Reflections
Provide a structured reflection covering:

1. **Trade-offs Considered:** Compare alternative designs (e.g., array vs. linked list, sentinel vs. no sentinel).
2. **Optimizations:** Suggest possible extensions (e.g., lazy deletion, memory pooling) and impact on complexity or memory.
3. **Implementation Challenges:** Note unexpected issues you faced (e.g., off-by-one in rotations) and how you resolved them.
4. **Lessons Learned:** Reflect on teamwork, API design clarity, test-driven approaches, and any insights for future DS projects.

---

## 5. Document Formatting & Submission
- Save as **`milestone1/docs/design_doc.md`** in Markdown format.  
- Use headings and tables for clarity.  
- Include inline code blocks for API signatures.  
- Keep diagrams simple and annotated.  
- Cite any external references or online resources.  

**Submit** this document alongside your code and tests in the `milestone1/` directory by the due date.

