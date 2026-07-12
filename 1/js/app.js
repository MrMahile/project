// ==================== Shared Utilities ====================

function getUser() {
    try {
        return JSON.parse(sessionStorage.getItem('currentUser'));
    } catch (e) {
        return null;
    }
}

function setUser(user) {
    sessionStorage.setItem('currentUser', JSON.stringify(user));
}

function clearUser() {
    sessionStorage.removeItem('currentUser');
}

function checkAuth() {
    const user = getUser();
    if (!user) {
        window.location.href = 'login.html';
        return null;
    }
    return user;
}

function logout() {
    clearUser();
    window.location.href = 'login.html';
}

function initTopbar(username) {
    const welcomeEl = document.getElementById('welcome-user');
    const logoutBtn = document.getElementById('logout-btn');
    if (welcomeEl) welcomeEl.textContent = username;
    if (logoutBtn) logoutBtn.addEventListener('click', logout);
}

function generateId(prefix) {
    return prefix + Math.floor(100000 + Math.random() * 900000);
}

function showError(inputEl, msg) {
    inputEl.classList.add('error');
    let errEl = inputEl.parentNode.querySelector('.error-text');
    if (!errEl) {
        errEl = document.createElement('div');
        errEl.className = 'error-text';
        inputEl.parentNode.appendChild(errEl);
    }
    errEl.textContent = msg;
    errEl.classList.add('show');
}

function clearError(inputEl) {
    inputEl.classList.remove('error');
    const errEl = inputEl.parentNode.querySelector('.error-text');
    if (errEl) errEl.classList.remove('show');
}

function clearAllErrors(form) {
    form.querySelectorAll('.error').forEach(el => el.classList.remove('error'));
    form.querySelectorAll('.error-text').forEach(el => el.classList.remove('show'));
}

// ==================== US001: Registration ====================

const countryCodes = [
    { code: '+1', country: 'USA' },
    { code: '+44', country: 'UK' },
    { code: '+91', country: 'India' },
    { code: '+61', country: 'Australia' },
    { code: '+86', country: 'China' },
    { code: '+81', country: 'Japan' },
    { code: '+49', country: 'Germany' },
    { code: '+33', country: 'France' },
    { code: '+971', country: 'UAE' },
    { code: '+966', country: 'Saudi Arabia' }
];

function populateCountryCodes() {
    const select = document.getElementById('country-code');
    if (!select) return;
    countryCodes.forEach(c => {
        const opt = document.createElement('option');
        opt.value = c.code;
        opt.textContent = c.code + ' (' + c.country + ')';
        select.appendChild(opt);
    });
}

function initRegistration() {
    populateCountryCodes();
    const form = document.getElementById('registration-form');
    const successScreen = document.getElementById('success-screen');

    form.addEventListener('submit', function (e) {
        e.preventDefault();
        clearAllErrors(form);
        let valid = true;

        const billNo = form['bill-no'];
        const name = form['cust-name'];
        const email = form['email'];
        const mobile = form['mobile'];
        const userId = form['user-id'];
        const password = form['password'];
        const confirmPassword = form['confirm-password'];

        if (!billNo.value || billNo.value.length !== 5 || !/^\d{5}$/.test(billNo.value)) {
            showError(billNo, 'Bill Number must be exactly 5 digits');
            valid = false;
        }

        if (!name.value || name.value.length > 50) {
            showError(name, 'Customer Name is required (max 50 characters)');
            valid = false;
        }

        if (!email.value || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.value)) {
            showError(email, 'Please enter a valid email address');
            valid = false;
        }

        if (!mobile.value || !/^\d{10}$/.test(mobile.value)) {
            showError(mobile, 'Mobile number must be exactly 10 digits');
            valid = false;
        }

        if (!userId.value || userId.value.length < 5 || userId.value.length > 20) {
            showError(userId, 'User ID must be between 5 and 20 characters');
            valid = false;
        }

        if (!password.value || password.value.length > 30) {
            showError(password, 'Password is required (max 30 characters)');
            valid = false;
        }

        if (password.value !== confirmPassword.value) {
            showError(confirmPassword, 'Passwords do not match');
            valid = false;
        }

        if (!valid) return;

        const custId = generateId('CID');
        document.getElementById('reg-cust-id').textContent = custId;
        document.getElementById('reg-cust-name').textContent = name.value;
        document.getElementById('reg-cust-email').textContent = email.value;

        form.style.display = 'none';
        successScreen.style.display = 'block';
    });

    form.addEventListener('reset', function () {
        clearAllErrors(form);
    });
}

// ==================== US002: Login ====================

const demoUsers = [
    { userId: 'admin', password: 'admin123', name: 'Admin User', email: 'admin@electricity.com' },
    { userId: 'john', password: 'john123', name: 'John Doe', email: 'john@example.com' },
    { userId: 'jane', password: 'jane123', name: 'Jane Smith', email: 'jane@example.com' }
];

function initLogin() {
    const form = document.getElementById('login-form');
    const errorMsg = document.getElementById('login-error');

    form.addEventListener('submit', function (e) {
        e.preventDefault();
        errorMsg.style.display = 'none';

        const userId = form['login-userid'].value.trim();
        const password = form['login-password'].value;

        if (!userId || !password) {
            errorMsg.textContent = 'Please enter both User ID and Password';
            errorMsg.style.display = 'block';
            return;
        }

        const user = demoUsers.find(u => u.userId === userId && u.password === password);
        if (user) {
            setUser(user);
            window.location.href = 'home.html';
        } else {
            errorMsg.textContent = 'Invalid User ID or Password. Try: admin / admin123';
            errorMsg.style.display = 'block';
        }
    });
}

// ==================== US002: Home / Pay Bill ====================

const sampleBills = [
    { id: 'BL001', month: 'January 2026', amount: 1250.00, dueDate: '2026-01-31', status: 'Pending' },
    { id: 'BL002', month: 'February 2026', amount: 980.50, dueDate: '2026-02-28', status: 'Pending' },
    { id: 'BL003', month: 'March 2026', amount: 1100.75, dueDate: '2026-03-31', status: 'Pending' },
    { id: 'BL004', month: 'April 2026', amount: 850.00, dueDate: '2026-04-30', status: 'Pending' },
    { id: 'BL005', month: 'May 2026', amount: 1320.25, dueDate: '2026-05-31', status: 'Pending' }
];

function initHome() {
    const user = checkAuth();
    if (!user) return;

    initTopbar(user.name);

    const tableBody = document.getElementById('bill-table-body');
    const totalEl = document.getElementById('total-amount');
    const proceedBtn = document.getElementById('proceed-btn');

    function renderBills() {
        tableBody.innerHTML = '';
        sampleBills.forEach(function (bill, index) {
            const tr = document.createElement('tr');
            tr.innerHTML =
                '<td><input type="checkbox" data-index="' + index + '" class="bill-check"></td>' +
                '<td>' + bill.id + '</td>' +
                '<td>' + bill.month + '</td>' +
                '<td>&#8377; ' + bill.amount.toFixed(2) + '</td>' +
                '<td>' + bill.dueDate + '</td>' +
                '<td>' + bill.status + '</td>';
            tableBody.appendChild(tr);
        });
    }

    function updateTotal() {
        let total = 0;
        tableBody.querySelectorAll('.bill-check:checked').forEach(function (cb) {
            const idx = parseInt(cb.dataset.index);
            total += sampleBills[idx].amount;
        });
        totalEl.textContent = 'Total Amount: \u20B9 ' + total.toFixed(2);
    }

    renderBills();

    tableBody.addEventListener('change', function (e) {
        if (e.target.classList.contains('bill-check')) {
            updateTotal();
        }
    });

    proceedBtn.addEventListener('click', function () {
        const selected = [];
        tableBody.querySelectorAll('.bill-check:checked').forEach(function (cb) {
            selected.push(sampleBills[parseInt(cb.dataset.index)]);
        });
        if (selected.length === 0) {
            alert('Please select at least one bill to pay.');
            return;
        }
        sessionStorage.setItem('selectedBills', JSON.stringify(selected));
        window.location.href = 'payment.html';
    });
}

// ==================== US003: Payment Page ====================

function initPayment() {
    const user = checkAuth();
    if (!user) return;

    initTopbar(user.name);

    const bills = JSON.parse(sessionStorage.getItem('selectedBills') || '[]');
    if (bills.length === 0) {
        window.location.href = 'home.html';
        return;
    }

    const billAmount = bills.reduce(function (sum, b) { return sum + b.amount; }, 0);
    const pgCharge = Math.round(billAmount * 0.02 * 100) / 100;
    const totalPayable = billAmount + pgCharge;

    document.getElementById('summary-bill-amount').textContent = '\u20B9 ' + billAmount.toFixed(2);
    document.getElementById('summary-pg-charge').textContent = '\u20B9 ' + pgCharge.toFixed(2);
    document.getElementById('summary-total').textContent = '\u20B9 ' + totalPayable.toFixed(2);

    const paymentData = {
        billAmount: billAmount,
        pgCharge: pgCharge,
        totalPayable: totalPayable,
        bills: bills
    };

    document.getElementById('pay-now-btn').addEventListener('click', function () {
        sessionStorage.setItem('paymentData', JSON.stringify(paymentData));
        window.location.href = 'card.html';
    });

    document.getElementById('back-home-btn').addEventListener('click', function () {
        window.location.href = 'home.html';
    });
}

// ==================== US003: Card Payment ====================

function initCardPayment() {
    const user = checkAuth();
    if (!user) return;

    initTopbar(user.name);

    const paymentData = JSON.parse(sessionStorage.getItem('paymentData') || 'null');
    if (!paymentData) {
        window.location.href = 'home.html';
        return;
    }

    document.getElementById('payable-amount').textContent = '\u20B9 ' + paymentData.totalPayable.toFixed(2);

    const form = document.getElementById('card-form');

    form.addEventListener('submit', function (e) {
        e.preventDefault();
        clearAllErrors(form);
        let valid = true;

        const cardNo = form['card-no'];
        const cardHolder = form['card-holder'];
        const expiry = form['expiry'];
        const cvv = form['cvv'];

        if (!cardNo.value || !/^\d{16}$/.test(cardNo.value.replace(/\s/g, ''))) {
            showError(cardNo, 'Card number must be exactly 16 digits');
            valid = false;
        }

        if (!cardHolder.value || cardHolder.value.length < 10) {
            showError(cardHolder, 'Card holder name must be at least 10 characters');
            valid = false;
        }

        if (!expiry.value || !/^(0[1-9]|1[0-2])\/\d{2}$/.test(expiry.value)) {
            showError(expiry, 'Expiry date must be in MM/YY format');
            valid = false;
        }

        if (!cvv.value || !/^\d{3}$/.test(cvv.value)) {
            showError(cvv, 'CVV must be exactly 3 digits');
            valid = false;
        }

        if (!valid) return;

        const txnId = generateId('TXN');
        paymentData.txnId = txnId;
        paymentData.cardLast4 = cardNo.value.slice(-4);
        paymentData.date = new Date().toLocaleString();
        sessionStorage.setItem('paymentData', JSON.stringify(paymentData));
        sessionStorage.removeItem('selectedBills');

        window.location.href = 'receipt.html';
    });
}

// ==================== US003: Receipt ====================

function initReceipt() {
    const user = checkAuth();
    if (!user) return;

    initTopbar(user.name);

    const paymentData = JSON.parse(sessionStorage.getItem('paymentData') || 'null');
    if (!paymentData) {
        window.location.href = 'home.html';
        return;
    }

    document.getElementById('txn-id').textContent = paymentData.txnId;
    document.getElementById('txn-date').textContent = paymentData.date;
    document.getElementById('txn-bill-amount').textContent = '\u20B9 ' + paymentData.billAmount.toFixed(2);
    document.getElementById('txn-pg-charge').textContent = '\u20B9 ' + paymentData.pgCharge.toFixed(2);
    document.getElementById('txn-total').textContent = '\u20B9 ' + paymentData.totalPayable.toFixed(2);
    document.getElementById('txn-card').textContent = '**** **** **** ' + paymentData.cardLast4;

    document.getElementById('download-btn').addEventListener('click', function () {
        const content =
            '====================================\n' +
            '        PAYMENT RECEIPT\n' +
            '====================================\n\n' +
            'Transaction ID : ' + paymentData.txnId + '\n' +
            'Date           : ' + paymentData.date + '\n' +
            'Customer       : ' + user.name + '\n' +
            'Email          : ' + user.email + '\n\n' +
            '------------------------------------\n' +
            'Bill Amount    : \u20B9 ' + paymentData.billAmount.toFixed(2) + '\n' +
            'PG Charge      : \u20B9 ' + paymentData.pgCharge.toFixed(2) + '\n' +
            'Total Paid     : \u20B9 ' + paymentData.totalPayable.toFixed(2) + '\n' +
            '------------------------------------\n' +
            'Card           : **** **** **** ' + paymentData.cardLast4 + '\n\n' +
            '        Payment Successful!\n' +
            '====================================\n';

        const blob = new Blob([content], { type: 'text/plain' });
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = 'receipt_' + paymentData.txnId + '.txt';
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
        URL.revokeObjectURL(url);
    });

    document.getElementById('home-btn').addEventListener('click', function () {
        sessionStorage.removeItem('paymentData');
        window.location.href = 'home.html';
    });
}

// ==================== US004: Register Complaint ====================

const complaintTypes = {
    'Billing Related': ['Incorrect Bill', 'Overcharge', 'Bill Not Received', 'Meter Reading Issue'],
    'Voltage Related': ['Low Voltage', 'High Voltage', 'Voltage Fluctuation'],
    'Frequent Disruption': ['Power Cut', 'Intermittent Supply', 'Scheduled Outage Not Notified'],
    'Street Light Related': ['Light Not Working', 'Dim Light', 'Damaged Pole', 'Wrong Timer'],
    'Pole Related': ['Damaged Pole', 'Tilted Pole', 'New Pole Request', 'Pole Removal']
};

function initComplaint() {
    const user = checkAuth();
    if (!user) return;

    initTopbar(user.name);

    const typeSelect = document.getElementById('complaint-type');
    const categorySelect = document.getElementById('category');
    const form = document.getElementById('complaint-form');
    const successScreen = document.getElementById('complaint-success');

    Object.keys(complaintTypes).forEach(function (type) {
        const opt = document.createElement('option');
        opt.value = type;
        opt.textContent = type;
        typeSelect.appendChild(opt);
    });

    typeSelect.addEventListener('change', function () {
        categorySelect.innerHTML = '<option value="">-- Select Category --</option>';
        const categories = complaintTypes[this.value] || [];
        categories.forEach(function (cat) {
            const opt = document.createElement('option');
            opt.value = cat;
            opt.textContent = cat;
            categorySelect.appendChild(opt);
        });
    });

    form.addEventListener('submit', function (e) {
        e.preventDefault();
        clearAllErrors(form);
        let valid = true;

        if (!typeSelect.value) {
            showError(typeSelect, 'Please select a complaint type');
            valid = false;
        }
        if (!categorySelect.value) {
            showError(categorySelect, 'Please select a category');
            valid = false;
        }
        if (!form['contact-person'].value) {
            showError(form['contact-person'], 'Contact Person is required');
            valid = false;
        }
        if (!form['consumer-no'].value || !/^\d{13}$/.test(form['consumer-no'].value)) {
            showError(form['consumer-no'], 'Consumer Number must be exactly 13 digits');
            valid = false;
        }
        if (!form['mobile-number'].value || !/^\d{10}$/.test(form['mobile-number'].value)) {
            showError(form['mobile-number'], 'Mobile Number must be exactly 10 digits');
            valid = false;
        }
        if (!form['problem-desc'].value) {
            showError(form['problem-desc'], 'Problem description is required');
            valid = false;
        }

        if (!valid) return;

        const complaintId = generateId('CMP');
        document.getElementById('complaint-id-display').textContent = complaintId;
        document.getElementById('complaint-type-display').textContent = typeSelect.value;
        document.getElementById('complaint-category-display').textContent = categorySelect.value;

        form.style.display = 'none';
        successScreen.style.display = 'block';
    });

    document.getElementById('cancel-btn').addEventListener('click', function () {
        form.reset();
        categorySelect.innerHTML = '<option value="">-- Select Category --</option>';
        clearAllErrors(form);
    });
}

// ==================== Complaint Status ====================

function initComplaintStatus() {
    const user = checkAuth();
    if (!user) return;

    initTopbar(user.name);

    const sampleComplaints = [
        { id: 'CMP123456', type: 'Billing Related', category: 'Incorrect Bill', date: '2026-06-15', status: 'In Progress' },
        { id: 'CMP789012', type: 'Voltage Related', category: 'Low Voltage', date: '2026-06-20', status: 'Resolved' },
        { id: 'CMP345678', type: 'Street Light Related', category: 'Light Not Working', date: '2026-07-01', status: 'Pending' }
    ];

    const tbody = document.getElementById('status-table-body');
    sampleComplaints.forEach(function (c) {
        const tr = document.createElement('tr');
        let statusClass = 'status-pending';
        if (c.status === 'Resolved') statusClass = 'status-resolved';
        else if (c.status === 'In Progress') statusClass = 'status-progress';

        tr.innerHTML =
            '<td>' + c.id + '</td>' +
            '<td>' + c.type + '</td>' +
            '<td>' + c.category + '</td>' +
            '<td>' + c.date + '</td>' +
            '<td><span class="' + statusClass + '">' + c.status + '</span></td>';
        tbody.appendChild(tr);
    });
}
