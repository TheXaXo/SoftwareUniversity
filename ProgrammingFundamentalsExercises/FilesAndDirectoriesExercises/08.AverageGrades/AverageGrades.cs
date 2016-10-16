using System;
using System.Collections.Generic;
using System.Linq;

class AverageGrades
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        List<Student> students = new List<Student>();

        for (int i = 1; i <= n; i++)
        {
            Student student = GetStudent();
            students.Add(student);
        }

        students = students.OrderBy(x => x.Name)
            .ThenByDescending(x => x.AverageGrade)
            .Where(x => x.AverageGrade >= 5)
            .ToList();

        foreach (Student student in students)
        {
            Console.WriteLine($"{student.Name} -> {student.AverageGrade:f2}");
        }
    }

    static Student GetStudent()
    {
        string[] input = Console.ReadLine().Split(' ');
        Student student = new Student();
        student.Name = input[0];

        for (int i = 1; i < input.Length; i++)
        {
            student.Grades.Add(double.Parse(input[i]));
        }

        return student;
    }
}

class Student
{
    public string Name { get; set; }
    public List<double> Grades = new List<double>();
    public double AverageGrade
    {
        get
        {
            return Grades.Sum() / Grades.Count;
        }
    }
}