using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Dddml.Wms.CmdLineTools
{
    class LineCounter
    {
        private string[] _sourceDirectories = new string[] { 
            //@"..\..\..\Dddml.Wms.Common",
            //@"..\..\..\Dddml.Wms.Services",
            //@"..\..\..\Dddml.Wms.HttpServices"
            @"C:\Users\yangjiefeng\Documents\GitHub\dddml-dotnet-tools\Dddml.Serialization",
            @"C:\Users\yangjiefeng\Documents\GitHub\dddml-dotnet-tools\Dddml.Core"
        };

        public string[] SourceDirectories
        {
            get { return _sourceDirectories; }
            set { _sourceDirectories = value; }
        }

        public int Count()
        {
            int i = 0;
            //var sb = new StringBuilder();
            var allLines = new List<string>();
            var allDirs = _sourceDirectories.SelectMany(d => Flatten(d, c => Directory.EnumerateDirectories(c)));
            foreach(var d in allDirs){
                //System.Console.WriteLine(d);
                foreach (var f in Directory.EnumerateFiles(d, "*.cs"))
                {
                    Console.WriteLine(f);
                    if (f.StartsWith("TemporaryGeneratedFile", StringComparison.InvariantCultureIgnoreCase))
                    {
                        continue;
                    }
                    i += ReadAllLines(f, allLines);
                }
            }
            Console.WriteLine("Total line count: " + i);
            
            var allSrcFilePath = @"..\..\TempSrcCode.cs";
            using (var writer = new StreamWriter(allSrcFilePath))
            {
                var someLines = Read3000Lines(allLines);
                writer.Write(someLines);
                Console.WriteLine("File created: " + allSrcFilePath);
            }
            return i;
        }

        private string Read3000Lines(List<string> allLines)
        {
            var sb = new StringBuilder();
            if (allLines.Count <= 3000)
            {
                foreach (var s in allLines)
                {
                    sb.AppendLine(s);
                }
            }
            else
            {
                for (int i = 0; i < 3000; i++)
                {
                    if (i < 1500)
                    {
                        sb.AppendLine(allLines[i]);
                    }
                    else
                    {
                        sb.AppendLine(allLines[allLines.Count - (3000 - i)]);
                    }
                }
            }
            return sb.ToString();
        }

        private int ReadAllLines(string file, List<string> allLines)
        {
            int i = 0;
            using (var reader = new StreamReader(file))
            {
                while (!reader.EndOfStream)
                {
                    var line = reader.ReadLine();
                    if (!String.IsNullOrWhiteSpace(line))
                    {
                        i++;
                        //sb.AppendLine(line);
                        allLines.Add(line);
                    }
                }
            }
            return i;
        }

        private static IEnumerable<T> Flatten<T>(T item, Func<T, IEnumerable<T>> next)
        {
            yield return item;

            foreach (T flattenedChild in next(item).SelectMany(child => Flatten(child, next)))
            {
                yield return flattenedChild;
            }
        }
    }
}
