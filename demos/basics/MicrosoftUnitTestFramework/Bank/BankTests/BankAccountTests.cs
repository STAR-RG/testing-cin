using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using BankAccountNS;

namespace BankTests
{
    [TestClass]
    public class BankAccountTests
    {
        // unit test code 
        [TestMethod]
        public void Debit_WithValidAmount_UpdatesBalance()
        {
            //arrange 
            double beginningBalance = 11.99;
            double debitAmount = 4.55;
            double expected = 7.44;
            BankAccount account = new BankAccount("Mr. Bryan Walton", beginningBalance);
            //act 
            account.Debit(debitAmount);
            //assert 
            double actual = account.Balance; 
            Assert.AreEqual(expected, actual, 0.001, "Account not debited correctly"); 
        }
        [TestMethod]
        public void Credit_WithValidAmount_UpdatesBalance()
        {
            double beginningBalance = 10.25;
            double creditAmount = 4.25;
            double expected = 14.50;
            BankAccount account = new BankAccount("Marcelo d'Amorim", beginningBalance);

            account.Credit(creditAmount);

            double actual = account.Balance;
            Assert.AreEqual(expected, actual, 0.001, "Account not credited correctly");
        }
    }
}
