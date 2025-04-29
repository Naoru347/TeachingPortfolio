# UML Diagram Guide for Milestone 2

Use this guide to create clear, informative UML class diagrams that accurately represent your ADT class hierarchy and relationships.

---

## 1. Purpose of Class Diagrams

- **Visualize Structure:** Show how classes relate (inheritance, composition, association).
- **Clarify Design:** Communicate API, data fields, and relationships at a glance.
- **Support Documentation:** Serve as a reference for your design document and code reviews.

---

## 2. Basic UML Class Notation

1. **Class Box:** Divided into three compartments:

   ```plaintext
   +-----------------------+
   |     ClassName        |
   +-----------------------+
   | - field1: Type       |
   | - field2: Type       |
   +-----------------------+
   | + method1(param): Ret |
   | + method2(): void    |
   +-----------------------+
   ```

   - **Visibility:** `+` public, `-` private, `#` protected (use `+` for public API).
   - **Fields:** List key data members (e.g., `head: Node<T>`, `size: int`).
   - **Methods:** Include signature, return type, and thrown exceptions if relevant.

2. **Relationships:**

   - **Inheritance (Generalization):** Solid line with hollow arrowhead: `SuperClass <|-- SubClass`
   - **Association:** Solid line connecting classes; label with role names or multiplicities.
   - **Aggregation:** Hollow diamond at the containing class end.
   - **Composition:** Filled diamond at the containing class end.
   - **Dependency:** Dashed arrow pointing from dependent to provider.

3. **Multiplicity:** Indicate cardinality at association ends: `1`, `0..1`, `*`, `1..*` (e.g., `1..*` for one-to-many).

---

## 3. Diagram Scope & Layout

- **Select Key Classes:** Include only the ADTs and helper classes (e.g., `Node`, `HashEntry`).
- **Group Related Classes:** Place base classes (e.g., `BinarySearchTree`) above subclasses (`AVLTree`).
- **Minimize Crossings:** Arrange for readability; avoid overlapping lines.
- **Spacing & Alignment:** Keep equal margins, align similar elements for a clean look.

---

## 4. Tools & Exporting (Free Options)

- **Diagrams.net (draw\.io):** Web-based and desktop app; intuitive drag-and-drop.
- **PlantUML:** Text-based diagrams; integrate with VS Code or generate via CLI.
- **Mermaid:** Markdown-friendly syntax; supported by many editors and static site generators.
- **yUML:** Simple web-based UML rendering from text.

### Export Tips

1. **Resolution:** Export at ≥ 300 DPI for embedding in documents.
2. **Format:** Use PNG for Markdown; PDF for high-fidelity prints.
3. **Naming Convention:** Save as `milestone2/docs/class_hierarchy.png` or `.pdf`.

---

## 5. Submission Checklist for UML
Submit all of the following in `milestone2/docs/`:

- **Diagram File:** `class_hierarchy.png` or `class_hierarchy.pdf`
- **Accuracy:** Diagram matches class names, method signatures, and relationships in your code
- **Annotations:** Correct visibility markers (`+`, `-`, `#`) and multiplicities (`1`, `0..*`, etc.)
- **Layout & Readability:** Clean arrangement, no overlapping lines, readable labels
- **Tool Usage Note:** A brief note in `milestone2/README.md` indicating which free tool you used (e.g., draw.io, PlantUML, Mermaid)
- **Export Quality:** Resolution ≥ 300 DPI with proper file naming conventions

---

**Use this checklist** to ensure your UML diagram is professional, accurate, and ready for inclusion in your project deliverables. to ensure your UML diagram is professional, accurate, and ready for inclusion in your project deliverables.**

