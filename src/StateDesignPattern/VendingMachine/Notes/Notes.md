Here is your well-formatted Markdown file, optimized for readability and IntelliJ Markdown preview:

```markdown
# Vending Machine Design

## Inventory
Inventory is simply a `Map<Product, Integer>`.  
**Made it concurrent** to prevent multiple users from modifying it at the same time.

### Product Properties
Each product has the following attributes:
1. **Name**
2. **Price**

---

## Overall Flow

### VendingMachine (Main API)
The `VendingMachine` is the core component of the system.  
**Used the Singleton Pattern** to ensure only one instance is created.

Once instantiated, it maintains references to:
- **All possible states**
- **Current state**
- **Inventory**
- **Selected product**
- **Total payment being made**

### Class Members
```java
private final Inventory inventory;
private final VendingMachineState idleState;
private final VendingMachineState readyState;
private final VendingMachineState dispenseState;
private final VendingMachineState returnChangeState;
private VendingMachineState currentState;
private Product selectedProduct;
private double totalPayment;
```

---

## State Flow

The overall state flow is as follows:

1. **Idle State** → (*Product selection possible here*)  
   ⬇
2. **Ready State** → (*Insert coins/notes, check payment status. If full payment is made, switch to Dispense State.*)
    - **Note:** Product cannot be dispensed until full or excess payment is received.  
      ⬇
3. **Dispense State** → (*Dispense the product. If change is required, switch to ReturnChange State; otherwise, switch to Idle State.*)  
   ⬇
4. **Idle State / Return Change State**

---

### Step 1: Product Selection
- The first step is to **select the product** from the available inventory.
- Once a product is selected, the vending machine transitions into the **Ready State**.

### Step 2 : Make Payment
- Payment can be made using coins, notes. Once full or excess payment is made, the flow goes to Dispense Product State.

### Step 3 : Collect the Product

### Step 4 : Dispense Change if any, else transition to **Idle State**

```