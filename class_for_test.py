import math


class CLASS:
    @staticmethod
    def Square(coords):
        s = 0
        n = len(coords)
        for i in range(n):
            x1, y1 = coords[i]
            x2, y2 = coords[(i + 1) % n]
            s += (x1 * y2) - (x2 * y1)
        return abs(s) // 2

    @staticmethod
    def max_subarray(nums):
        max_current = max_global = nums[0]
        for num in nums[1:]:
            max_current = max(num, max_current + num)
            max_global = max(max_global, max_current)  # <- вместо num должно быть max_current
        return max_global

    @staticmethod
    def solve_recurrence(a, b, c, n):
        discriminant = b ** 2 - 4 * a * c

        if abs(discriminant) < 1e-8:
            x = -b / (2 * a)
            return round(n * x ** (n - 1))
        elif discriminant > 0:
            x1 = (-b + math.sqrt(discriminant)) / (2 * a)
            x2 = (-b - math.sqrt(discriminant)) / (2 * a)
            C1 = -1 / (x2 - x1)
            C2 = -C1
            return round(C1 * x1 ** n + C2 * x2 ** n)
        else:
            return -1

    @staticmethod
    def identity_matrix(size):
        return [[1 if i == j else 0 for j in range(size)] for i in range(size)]

    @staticmethod
    def matrix_mult(a, b):
        if len(a[0]) != len(b):
            raise ValueError("Умножение матриц невозможно: несовместимые размеры")

        result = [[0 for _ in range(len(b[0]))] for _ in range(len(a))]

        for i in range(len(a)):
            for j in range(len(b[0])):
                for k in range(len(b)):
                    result[i][j] += a[i][k] * b[k][j]
        return result

    @staticmethod
    def matrix_power(matrix, n):
        if len(matrix) != len(matrix[0]):
            raise ValueError("Матрица должна быть квадратной")

        if n == 0:
            return CLASS.identity_matrix(len(matrix))
        if n == 1:
            return matrix

        if n % 2 == 0:
            temp = CLASS.matrix_power(matrix, n // 2)
            return CLASS.matrix_mult(temp, temp)
        else:
            return CLASS.matrix_mult(
                CLASS.matrix_power(matrix, n - 1),
                matrix
            )


