using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;

class MentorGroup
{
    static void Main(string[] args)
    {
        string command = Console.ReadLine();
        List<Student> allStudents = new List<Student>();

        while (command != "end of dates")
        {
            Student student = GetStudent(command);

            if (allStudents.Exists(x => x.UserName == student.UserName))
            {
                Student currentStudent = allStudents.First(x => x.UserName == student.UserName);
                currentStudent.Dates = currentStudent.Dates.Concat(student.Dates).ToList();
            }
            else
            {
                allStudents.Add(student);
            }

            command = Console.ReadLine();
        }

        command = Console.ReadLine();

        while (command != "end of comments")
        {
            string[] split = command.Split('-');
            string userName = split[0];
            string comment = split[1];

            if (allStudents.Exists(x => x.UserName == userName))
            {
                Student currentStudent = allStudents.First(x => x.UserName == userName);
                currentStudent.Comments.Add(comment);
            }

            command = Console.ReadLine();
        }

        allStudents = allStudents.OrderBy(x => x.UserName).ToList();
        foreach (Student student in allStudents)
        {
            student.Dates = student.Dates.OrderBy(x => x).ToList();

            Console.WriteLine(student.UserName);
            Console.WriteLine("Comments:");
            {
                foreach (string comment in student.Comments)
                {
                    Console.WriteLine($"- {comment}");
                }
            }
            Console.WriteLine("Dates attended:");
            foreach (DateTime date in student.Dates)
            {
                Console.WriteLine($"-- {date.ToString("dd/MM/yyyy")}");
            }
        }
    }

    static Student GetStudent(string input)
    {
        Student student = new Student();
        char[] separators = { ' ', ',' };
        string[] split = input.Split(separators);
        student.UserName = split[0];

        if (split.Length > 1)
        {
            for (int i = 1; i < split.Length; i++)
            {
                DateTime date = DateTime.ParseExact(split[i], "dd/MM/yyyy", CultureInfo.InvariantCulture);
                student.Dates.Add(date);
            }
        }

        return student;
    }
}

class Student
{
    public string UserName { get; set; }
    public List<DateTime> Dates = new List<DateTime>();
    public List<string> Comments = new List<string>();
}