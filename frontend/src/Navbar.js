import './Navbar.css';

export default function Navbar() { 
    return (  
        <ul>
            <li><a class="active" href="#home">Home</a></li>
            <li><a href="#java">Java</a></li>
            <li><a href="#spring">Spring</a></li>
            <li><a href="#sql">SQL</a></li>
            <li><a href="#design-pattern">Design Pattern</a></li>
            <li style={{float:'right'}} ><a href="#about">About</a></li>
        </ul>
    );
}
 