def check_if_valid (operator):
    match operator:
        case "+":
            return True
        case "-":
            return True
        case "*":
            return True
        case "/":
            return True
        case "":
            return True
        case _:
            return False