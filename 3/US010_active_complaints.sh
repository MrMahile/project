#!/bin/bash
# US010: Count the number of active complaints
# File: Complaints.txt
# Format: ConsumerId|CustomerName|ComplaintType|Category|Address|Phone|Status
# Fields are separated by pipe "|"

echo "=== US010: Count of Active Complaints ==="
echo ""

FILE="data/Complaints.txt"

if [ ! -f "$FILE" ]; then
    echo "Error: File $FILE not found."
    exit 1
fi

ACTIVE_COUNT=$(awk -F'|' '$7 == "Active" { count++ } END { print count }' "$FILE")

echo "Total Active Complaints: $ACTIVE_COUNT"
echo ""
echo "Details of Active Complaints:"
echo "----------------------------"
printf "%-12s | %-20s | %-20s | %-25s\n" "ConsumerId" "CustomerName" "ComplaintType" "Category"
echo "------------ | -------------------- | -------------------- | -------------------------"
awk -F'|' '$7 == "Active" { printf "%-12s | %-20s | %-20s | %-25s\n", $1, $2, $3, $4 }' "$FILE"
