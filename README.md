# YouTube Trend Explorer (Autonomous Data Scraper)

## Overview
This project is an autonomous web scraping pipeline designed to extract YouTube video data efficiently and securely. It is built to bypass basic anti-bot mechanisms and store the collected data in an SQLite database. This system serves as the foundational data acquisition layer for a Machine Learning dataset generation project (TÜBİTAK 2209-A).

## Key Features
* **Anti-Bot Mechanisms:** Implements dynamic User-Agent rotation, `Referer` spoofing, and randomized sleep intervals (search and video analysis delays) to mimic organic human behavior.
* **Data Extraction:** Extracts video IDs, titles, view counts, likes, and metadata tags using a combination of Jsoup and Regex (Pattern/Matcher).
* **Database Integration:** Automatically processes and saves the extracted data into an SQLite database for further analysis.
* **Clean Architecture:** Developed using Object-Oriented Programming (OOP) principles, separating the system into extraction, model, and storage layers.

## Tech Stack
* **Language:** Java
* **Libraries:** Jsoup (HTML/XML parsing), SQLite JDBC
* **Data Science (Upcoming):** Python, Pandas (Jupyter Notebooks for data preprocessing)

## Project Structure
* `data.extraction/`: Contains the crawler, content extractor, and User-Agent manager.
* `data.model/`: Contains data objects (`VideoData`).
* `data.storage/`: Handles the SQLite database connection and repository operations.
* `ai_core/`: Contains Python Jupyter Notebooks for data cleaning and Machine Learning preparation.
