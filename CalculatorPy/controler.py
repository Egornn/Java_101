import sys
import operations as oper
import connector as check
def calculator_exe():
    while True:
        operator = "fuck"
        while (not check.check_if_valid(operator)):
            operator=input ("Choose an operation (leave empty to exit): ")
        if operator=="":
            print("Goodbye")
            sys.exit()
        term1 = float (input ("Input the first term: "))
        term2 = float (input ("Input the second term: "))
        
        try :
            match operator:
                case "+":
                    print(f"{term1} + {term2} = {oper.sum_two(term1, term2)}")
                case "-":
                    print(f"{term1} - {term2} = {oper.substruct_two(term1, term2)}")
                case "*":
                    print(f"{term1} * {term2} = {oper.multiply_two(term1, term2)}")
                case "/":
                    print(f"{term1} / {term2} = {oper.divide_two(term1, term2)}")
                
        except:
            print ("Incorrect input")

        
