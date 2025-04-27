# **Lab 11: Simple Log Analyzer (Java Edition)**

---

## **Objectives**
1. Learn to read and process data from files in Java.
2. Use HashMaps to aggregate and analyze data.
3. Apply Sets to identify unique data points.
4. Practice writing processed results back to output files.

---

## **Scenario**
You are working as a system administrator and need to analyze a web server log file. Your task is to extract useful information from the log file, such as identifying frequent IP addresses and listing all unique IPs. This type of analysis is critical for monitoring server traffic and detecting anomalies.

---

## **Instructions**

### **Part 1: Parse the Log File**
1. **Download the Sample Log File**:
   - A sample log file (`WebServer.log`) will be provided.
   - Each line follows a format like:
     ```
     192.168.1.1 - - [01/Dec/2024:12:34:56 +0000] "GET /index.html HTTP/1.1" 200 1024
     10.0.0.2 - - [01/Dec/2024:12:35:00 +0000] "POST /form.html HTTP/1.1" 302 512
     ```

2. **Create a Java Class `LogAnalyzer.java`**:
   - Read the file line-by-line using `BufferedReader`.
   - Extract the IP address from each line using `String.split()` or regex.
   - Store extracted IPs in a `List<String>`.

---

### **Part 2: Analyze IP Address Data**
1. **Count IP Frequencies**:
   - Use a `HashMap<String, Integer>` to count how many times each IP appears.

2. **Identify Top IPs**:
   - Sort the map entries by value (frequency) and display the top 5 IPs.

3. **Unique IPs**:
   - Use a `HashSet<String>` to find and store all unique IP addresses.
   - Print the total number of unique IPs.

---

### **Part 3: Save Analysis Results**
1. **Save IP Frequencies to `ip_frequencies.txt`**:
   - Format:
     ```
     IP Address	Count
     192.168.1.1	5
     10.0.0.2	3
     ```

2. **Save Unique IPs to `unique_ips.txt`**:
   - One IP address per line.

---

### **Part 4: Stretch Challenges (Optional)**
1. **Filter by Time Range**:
   - Prompt the user to enter a start and end timestamp.
   - Only analyze lines from the log file that fall within the time range.

2. **Detect Suspicious Activity**:
   - Identify any IPs with more than 50 requests.
   - Write these IPs to `suspicious_ips.txt`.

---

## **Submission Instructions**
1. Submit the following to your GitHub Classroom repository:
   - `LogAnalyzer.java`
   - `ip_frequencies.txt`
   - `unique_ips.txt`
   - Optionally: `suspicious_ips.txt`
2. Ensure your code is well-commented and follows Java conventions.

---

## **Hints and Tips**
1. **Reading Files**:
   - Use `BufferedReader` and `FileReader` for efficient file reading.
   - Example:
     ```java
     BufferedReader reader = new BufferedReader(new FileReader("WebServer.log"));
     String line;
     while ((line = reader.readLine()) != null) {
         // Process line
     }
     reader.close();
     ```

2. **Extracting IPs**:
   - Use `line.split(" ")` to get the first token (IP address), or regex for more control.

3. **Sorting a HashMap by Values**:
   - Convert entries to a list and use `Collections.sort()` with a custom comparator.

4. **Writing to Files**:
   - Use `BufferedWriter` or `PrintWriter` to write results to a file.

5. **Using Sets**:
   - `Set<String> uniqueIps = new HashSet<>(ipList);`

---

## **Example Output**
- **Top 5 IPs**:
  ```
  Top 5 IPs:
  192.168.1.1 - 25 requests
  10.0.0.2 - 18 requests
  ...
  ```

- **Unique IP Count**:
  ```
  Total Unique IPs: 42
  ```

- **Files**:
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

Good luck with your log analysis! This is a great opportunity to solidify your understanding of Java file I/O and data structures.

