#!/bin/bash
# US012: Calculate average bill for each consumer for last 5 months
# File: consumer_bills.txt
# Format: ConsumerID|CustomerName|Month1|Month2|Month3|Month4|Month5
# Output: ConsumerID|CustomerName|Average Bill (descending order)

echo "=== US012: Average Bill of Consumers ==="
echo ""

FILE="data/consumer_bills.txt"

if [ ! -f "$FILE" ]; then
    echo "Error: File $FILE not found."
    exit 1
fi

echo "ConsumerID  | Customer Name     | Average Bill"
echo "----------- | ----------------- | ------------"

awk -F'|' 'NR > 1 {
    avg = ($3 + $4 + $5 + $6 + $7) / 5
    printf "%-11s | %-17s | %.2f\n", $1, $2, avg
}' "$FILE" | sort -t'|' -k3 -rn
