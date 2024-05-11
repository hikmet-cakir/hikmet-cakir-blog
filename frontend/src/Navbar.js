import './Navbar.css';

export default function Navbar() { 
    return (  
        <div class="navbar-topic">
            <a class="active" href="#home">Home</a>
            <a href="#java">Java</a>
            <a href="#spring">Spring</a>
            <a href="#sql">SQL</a>
            <a href="#design-pattern">Design Pattern</a>
            <a href="#about" style={{float:'right'}} >About</a>
        </div>
    );
}
 