using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Core12.Models
{
    public class User
    {
        /// <summary>
        /// example: does not matter
        /// </summary>
        public int Id { get; set; }

        /// <summary>
        /// example: does not matter
        /// </summary>
        public String lastname { get; set; }

        /// <summary>
        /// example: does not matter
        /// </summary>
        public String firstname { get; set; }

        /// <summary>
        /// example: does not matter
        /// </summary>
        [Required]
        public String email { get; set; }

        /// <summary>
        /// example: does not matter
        /// </summary>
        [Required]
        public String password{ get; set; }

        /// <summary>
        /// example: does not matter
        /// </summary>
        [Required]
        public String status { get; set; }
        
        /// <summary>
        /// example: does not matter
        /// </summary>
        [Required]
        public String role { get; set; }
    }
}
