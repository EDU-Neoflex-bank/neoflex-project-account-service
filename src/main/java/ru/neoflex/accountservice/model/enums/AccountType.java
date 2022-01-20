package ru.neoflex.accountservice.model.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum AccountType {
    CHECKING("Checking Account", "A checking account offers easy access to your money for your daily transactional needs and helps keep your cash secure. Customers can typically use a debit card or checks to make purchases or pay bills. Accounts may have different options to help avoid the monthly service fee. To determine the most economical choice, compare the benefits of different checking accounts with the services you actually need."),
    SAVINGS("Savings Account", "A savings account allows you to accumulate interest on funds you’ve saved for future needs. Interest rates can be compounded on a daily, weekly, monthly, or annual basis. Savings accounts vary by monthly service fees, interest rates, method used to calculate interest, and minimum opening deposit. Understanding the account’s terms and benefits will allow for a more informed decision on the account best suited for your needs."),
    CD("Certificate of Deposit", "Certificates of deposit, or CDs, allow you to invest your money at a set interest rate for a pre-set period of time. CDs often have higher interest rates than traditional savings accounts because the money you deposit is tied up for the life of the certificate – which can range from a few months to several years. Be sure you do not need to draw on those funds before you open a CD, as early withdrawals may have financial penalties."),
    MONEYMARKET("Money Market Account", "Money market accounts are similar to savings accounts, but they require you to maintain a higher balance to avoid a monthly service fee. Where savings accounts usually have a fixed interest rate, these accounts have rates that vary regularly based on money markets. Money market accounts can have tiered interest rates, providing more favorable rates based on higher balances. Some money market accounts also allow you to write checks against your funds, but on a more limited basis."),
    IRA("Individual Retirement Account", "RAs, or Individual Retirement Accounts, allow you to save independently for your retirement. These plans are useful if your employer doesn’t offer a 401(k) or other qualified employer sponsored retirement plan (QRP), including 403(b) and governmental 457(b), or you want to save more than your employer-sponsored plan allows. These accounts come in two types: the Traditional IRA and Roth IRA.");

    private static final List<AccountType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    private final String title;
    private final String description;

    AccountType(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public AccountType getRandomAccountType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
