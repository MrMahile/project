#!/bin/bash
# US011: Display details of a specific consumer
# File: bill.txt
# Format: ConsumerId|CustomerName|PhoneNumber|Address|BillAmount|ModeOfPayment
# Required output: ConsumerId|CustomerName|BillAmount|ModeOfPayment
# If not found: "Consumer Not Found"

echo "=== US011: Consumer Details Search ==="
echo ""

FILE="data/bill.txt"
SEARCH_ID="1101132490783"

if [ ! -f "$FILE" ]; then
    echo "Error: File $FILE not found."
    exit 1
fi

echo "Searching for ConsumerID: $SEARCH_ID"
echo ""

printf "%-14s | %-19s | %-12s | %-20s\n" "ConsumerId" "CustomerName" "BillAmount" "ModeOfPayment"
echo "--------------- | ------------------- | ------------ | -------------------"
awk -F'|' -v id="$SEARCH_ID" '$1 == id {
    printf "%-14s | %-19s | %-12s | %-20s\n", $1, $2, $5, $6
    found=1
}
END {
    if (!found) print "Consumer Not Found"
}' "$FILE"
