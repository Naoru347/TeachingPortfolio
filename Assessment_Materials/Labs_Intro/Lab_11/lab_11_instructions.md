# **Lab 11: Simple Log Analyzer**

---

## **Objectives**
1. Learn to read and process data from files in Python.
2. Use dictionaries for data aggregation and analysis.
3. Apply set operations to filter and identify unique data points.
4. Practice saving processed data back to files for reporting.

---

## **Scenario**
You are working as a system administrator and need to analyze a web server log file. Your task is to extract useful information from the log file, such as identifying frequent IP addresses and listing all unique IPs. This type of analysis is critical for monitoring server traffic and detecting anomalies.

---

## **Instructions**

### **Part 1: Parse the Log File**
1. **Download the Sample Log File**:
   - A sample log file (`webserver.log`) will be provided.
   - It contains lines in the format:
     ```
     192.168.1.1 - - [01/Dec/2024:12:34:56 +0000] "GET /index.html HTTP/1.1" 200 1024
     10.0.0.2 - - [01/Dec/2024:12:35:00 +0000] "POST /form.html HTTP/1.1" 302 512
     ```
   - Each line includes an IP address, timestamp, and request details.

2. **Read the File**:
   - Write a Python script named `log_analyzer.py`.
   - Open and read the log file line by line.

3. **Extract IP Addresses**:
   - Use string manipulation or Python’s `re` module to extract IP addresses from each line.
   - Store the extracted IPs in a list.

---

### **Part 2: Analyze IP Address Data**
1. **Count IP Frequencies**:
   - Use a dictionary to count how many times each IP address appears in the log.
   - Example:
     ```python
     ip_counts = {
         "192.168.1.1": 5,
         "10.0.0.2": 3
     }
     ```

2. **Identify Top IPs**:
   - Sort the dictionary by frequency and print the top 5 most frequent IP addresses along with their counts.

3. **Unique IPs**:
   - Convert the list of IPs into a set to find all unique IP addresses.
   - Print the total number of unique IPs.

---

### **Part 3: Save Analysis Results**
1. **Save IP Frequencies**:
   - Write the dictionary data to a file named `ip_frequencies.txt` in a tabular format:
     ```
     IP Address	Count
     192.168.1.1	5
     10.0.0.2	3
     ```

2. **Save Unique IPs**:
   - Write all unique IP addresses to a file named `unique_ips.txt` (one IP per line).

---

### **Part 4: Stretch Challenges (Optional)**
1. **Filter by Time Range**:
   - Allow the user to input a start and end time (e.g., `2024-12-01 12:00` to `2024-12-01 14:00`).
   - Extract and analyze only the log entries within that time range.

2. **Detect Suspicious Activity**:
   - Identify IPs that made more than 50 requests in the log file and save them to a file named `suspicious_ips.txt`.

---

## **Additional Notes**
1. **About the `re` Module:**
   - The `re` module in Python is used for working with *regular expressions* (aka: regex), which allow you to search for and extract patterns from text. 
   - Common use cases include:
     - Extracting specific data from text (e.g., IP addresses, email addresses, dates).
     - Validating input formats (e.g., checking if a string is a valid email).
     - Replacing parts of a string.
   - Sample syntax for extracting IP addresses:
     ```python
     import re
     line = "192.168.1.1 - - [01/Dec/2024:12:34:56 +0000] \"GET /index.html HTTP/1.1\" 200 1024"
     match = re.match(r"(\d+\.\d+\.\d+\.\d+)", line)
     if match:
         ip = match.group(1)
         print(ip)  # Outputs: 192.168.1.1
     ```

2. **Regular Expression, Extended Example:**
   As an extended example, assume, for a moment, that we wanted to search for possible phone numbers in a file, we know we'd need to look for a pattern of 3 digits, followed by another 3 digits, and then 4 digits. Additionally, there may or may not be parentheses `()` around the first set of three digits. We could write a regular expression like this:
   ```python
   import re

   # Example line to search for a phone number
   line = "You can contact me at (123) 456-7890 or 987-654-3210."

   # Regular expression to match phone numbers
   pattern = r"\(?\d{3}\)?[-.\s]?\d{3}[-.\s]?\d{4}"

   # Find all matches in the line
   matches = re.findall(pattern, line)
   print(matches)
   ```

   **Explanation of the Regular Expression:**
   - `\(?`: Matches an optional opening parenthesis.
   - `\d{3}`: Matches exactly three digits.
   - `\)?`: Matches an optional closing parenthesis.
   - `[-.\s]?`: Matches an optional separator, which can be a dash `-`, period `.`, or space.
   - `\d{3}`: Matches another three digits.
   - `[-.\s]?`: Matches another optional separator.
   - `\d{4}`: Matches the final four digits.

   **Output:**
   ```
   ['(123) 456-7890', '987-654-3210']
   ```

3. **Starter Files:**
   - Students will only be provided the log file (`webserver.log`).
   - No starter scripts or files will be provided. At this point in the semester, you are expected to write your own code from scratch based on the instructions provided.

---

## **Submission Instructions**
1. Submit the following files to your GitHub classroom repo:
   - `log_analyzer.py` (your Python script).
   - `ip_frequencies.txt` (output file with IP frequency counts).
   - `unique_ips.txt` (output file with unique IPs).
   - Optionally, submit `suspicious_ips.txt` if you complete the stretch challenge.

2. Ensure your code is well-commented and follows Python best practices.

---

## **Hints and Tips**
1. **Reading Files**:
   - Use Python’s `with open()` syntax to read the log file safely.

2. **String Manipulation**:
   - Split each line using `.split()` or use regular expressions for precise extraction.
   - Example using regex to extract IPs:
     ```python
     import re
     match = re.match(r"(\d+\.\d+\.\d+\.\d+)", line)
     if match:
         ip = match.group(1)
     ```

3. **Sorting a Dictionary**:
   - Use the `sorted()` function to sort the dictionary by values:
     ```python
     sorted_ips = sorted(ip_counts.items(), key=lambda item: item[1], reverse=True)
     ```

4. **Working with Sets**:
   - Convert a list to a set to get unique items:
     ```python
     unique_ips = set(ip_list)
     ```

---

## **Example Output**
- **Top 5 IPs:**
  ```
  Top 5 IPs:
  192.168.1.1 - 25 requests
  10.0.0.2 - 18 requests
  ...
  ```

- **Unique IPs Count:**
  ```
  Total Unique IPs: 42
  ```

- **Output Files:**
  - `ip_frequencies.txt`:
    ```
    IP Address	Count
    192.168.1.1	25
    10.0.0.2	18
    ```
  - `unique_ips.txt`:
    ```
    192.168.1.1
    10.0.0.2
    ...
    ```

---

Good luck with your log analysis! This exercise will provide valuable skills for real-world systems administration and data analysis.
